package com.mrcode.action.order;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.joda.time.DateTime;
import org.joda.time.DurationFieldType;
import org.springframework.beans.factory.annotation.Autowired;

import com.mrcode.service.ContactorsService;
import com.mrcode.service.GrouppurchasevoucherService;
import com.mrcode.service.MrcodeorderService;
import com.mrcode.service.PasswordService;
import com.mrcode.service.RoomService;
import com.mrcode.service.RoomtypeService;
import com.mrcode.utils.Const;
import com.mrcode.utils.DateUtils;
import com.mrcode.utils.JsonValueFormat;
import com.mrcode.utils.MakeOrderNum;
import com.mrcode.utils.MessageSend;
import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.common.WebApplication;
import com.mrcode.model.Contactors;
import com.mrcode.model.Customer;
import com.mrcode.model.Floor;
import com.mrcode.model.Grouppurchasevoucher;
import com.mrcode.model.Mrcodeorder;
import com.mrcode.model.Password;
import com.mrcode.model.Room;
import com.mrcode.model.Roomtype;

@ParentPackage("customers")
@Namespace("/order")
public class OrderAction extends BaseAction<Mrcodeorder>{

	@Autowired
	RoomtypeService roomtypeService;
	@Autowired
	RoomService roomService;
	@Autowired
	GrouppurchasevoucherService grouppurchasevoucherService;
	@Autowired
	ContactorsService contactorsService;
	@Autowired
	MrcodeorderService mrcodeorderService;
	@Autowired
	PasswordService passwordService;
	
	@Action(value = "toFirst", results = { @Result(name = "stepFirstUI", location = ViewLocation.View_ROOT
			+ "orderstep0.jsp") })
	public String toFirst() throws Exception{
		//跳转至入住第一步，选择日期页面
		
		Customer customer = (Customer)session.get(Const.CUSTOMER);
		//获得房间类型
		Integer typeId = getIntParameter("typeId", -1);
		Integer validCount = grouppurchasevoucherService.getTypeCount(customer, typeId);
		
		dataMap.put("id", typeId);
		Roomtype roomtype = roomtypeService.findUniqueByHql("from Roomtype r left join fetch r.hotel where r.id=:id", dataMap);
		session.put("roomtype", roomtype); //选择的房间类型
		session.put("validCount", validCount); //团购券数量
		
		return "stepFirstUI";
	}
	
	@Action(value = "checkRoom")
	public void checkRoom() throws Exception {
		//TODO 查看是否有可用的房间
		// 获得住宿日期
		Date begin = null, end = null;
		try {
			begin = DateUtils.parseDate(getParameter("begin"), "yyyy-MM-dd");
		} catch (Exception e) {
			// TODO: handle exception
			begin = null;
		}
		try {
			end = DateUtils.parseDate(getParameter("end"), "yyyy-MM-dd");
		} catch (Exception e) {
			// TODO: handle exception
			end = null;
		}

		long days = DateUtils.lengthBetween(new DateTime(begin), new DateTime(
				end), DurationFieldType.days());

		Integer typeId = null;
		// 查询所订房间类型的具体信息
		try {
			typeId = ((Roomtype) session.get("roomtype")).getId();
		} catch (Exception e) {
			// TODO: 未选择团购券,跳转到选择团购券页面
			WebApplication.getResponse().sendRedirect(
					WebApplication.getRequest().getContextPath()
							+ "/customer/toOrder");
		}

		Roomtype roomtype = roomtypeService.getWithDetail(typeId);

		// 请求酒店可用的房间
		String url_str = "http://localhost:8080/JavaPrj_9/reserv.htm?action=findAvailRoomsInJson";// 获取用户认证的帐号URL
		URL url = new URL(url_str);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// connection.connect();
		// 默认是get 方式
		connection.setRequestMethod("POST");
		// 设置是否向connection输出，如果是post请求，参数要放在http正文内，因此需要设为true
		connection.setDoOutput(true);
		// Post 请求不能使用缓存
		connection.setUseCaches(false);
		// 要上传的参数
		PrintWriter pw = new PrintWriter(connection.getOutputStream());
		String content = "from="
				+ URLEncoder.encode(DateUtils.formatStr(begin), "UTF-8")
				+ "&to=" + URLEncoder.encode(DateUtils.formatStr(end), "UTF-8");
		pw.print(content);
		pw.flush();
		pw.close();
		int code = connection.getResponseCode();
		if (code == 404) {
			throw new Exception("连接无效，找不到此次连接的会话信息！");
		}
		if (code == 500) {
			throw new Exception("连接服务器发生内部错误！");
		}
		if (code != 200) {
			throw new Exception("发生其它错误，连接服务器返回 " + code);
		}
		InputStream is = connection.getInputStream();
		byte[] response = new byte[is.available()];
		is.read(response);
		is.close();
		if (response == null || response.length == 0) {
			throw new Exception("连接无效，找不到此次连接的会话信息！");
		}
		String json = new String(response, "UTF-8");
		System.out.println(json);
		JSONObject jsonObject = JSONObject.fromObject(json);
		JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("rooms"));
		//把获得的json组装成对象
        String rmIds = "";
        for(Object object : jsonArray){
        	String rmId = ((JSONObject)object).getString("rmId");
        	rmIds += rmId+",";
        }
        if (rmIds.contains(",")) {
			rmIds = rmIds.substring(0, rmIds.length()-1);
		}
        List<Room> rooms = roomService.getByRoomNumAndType(rmIds, roomtype);
		
		if(rooms==null || rooms.isEmpty()){
			writeStringToResponse("0");
		}else {
			writeStringToResponse("1");
		}
	}
	
	@Action(value = "toSecond", results = { @Result(name = "stepSecondUI", location = ViewLocation.View_ROOT
			+ "orderstep1.jsp") })
	public String toSecond() throws Exception{
		//跳转至入住第二步，选择房间页面
		//获得住宿日期
		Date begin=null, end=null;
		try {
			begin = DateUtils.parseDate(getParameter("begin"), "yyyy-MM-dd");
		} catch (Exception e) {
			// TODO: handle exception
			begin = null;
		}
		try {
			end = DateUtils.parseDate(getParameter("end"), "yyyy-MM-dd");
		} catch (Exception e) {
			// TODO: handle exception
			end = null;
		}
		
		long days = DateUtils.lengthBetween(new DateTime(begin), new DateTime(end), DurationFieldType.days());
		session.put("begin", begin);
		session.put("end", end);
		session.put("days", (int)days);//选择的天数
		
		Integer typeId = null;
		//查询所订房间类型的具体信息
		try {
			typeId = ((Roomtype)session.get("roomtype")).getId();
		} catch (Exception e) {
			// TODO: 未选择团购券,跳转到选择团购券页面
			WebApplication.getResponse().sendRedirect(WebApplication.getRequest().getContextPath()+"/customer/toOrder");
		}
		
		Roomtype roomtype = roomtypeService.getWithDetail(typeId);
		
		//请求酒店可用的房间
		String url_str = "http://localhost:8080/JavaPrj_9/reserv.htm?action=findAvailRoomsInJson";//获取用户认证的帐号URL
        URL url = new URL(url_str);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// connection.connect();
		// 默认是get 方式
		connection.setRequestMethod("POST");
		// 设置是否向connection输出，如果是post请求，参数要放在http正文内，因此需要设为true
		connection.setDoOutput(true);
		// Post 请求不能使用缓存
		connection.setUseCaches(false);
		//要上传的参数  
        PrintWriter pw=new PrintWriter(connection.getOutputStream());
        String content = "from=" + URLEncoder.encode(DateUtils.formatStr(begin), "UTF-8")+
        		"&to="+ URLEncoder.encode(DateUtils.formatStr(end), "UTF-8");  
        pw.print(content);
        pw.flush();
        pw.close();
        int code = connection.getResponseCode();
        if (code == 404) {
            throw new Exception("连接无效，找不到此次连接的会话信息！");
        }
        if (code == 500) {
            throw new Exception("连接服务器发生内部错误！");
        }
        if (code != 200) {
            throw new Exception("发生其它错误，连接服务器返回 " + code);
        }
        InputStream is = connection.getInputStream();
        byte[] response = new byte[is.available()];
        is.read(response);
        is.close();
        if (response == null || response.length == 0) {
            throw new Exception("连接无效，找不到此次连接的会话信息！");
        }
        String json = new String(response, "UTF-8");
        System.out.println(json);
        JSONObject jsonObject = JSONObject.fromObject( json );
        JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("rooms"));
        //把获得的json组装成对象
        String rmIds = "";
        for(Object object : jsonArray){
        	String rmId = ((JSONObject)object).getString("rmId");
        	rmIds += rmId+",";
        }
        if (rmIds.contains(",")) {
			rmIds = rmIds.substring(0, rmIds.length()-1);
		}
        List<Room> rooms = roomService.getByRoomNumAndType(rmIds, roomtype);
        //把楼层和房间变成map
        Map<Floor, List<Room>> frMap = new LinkedHashMap<Floor, List<Room>>();
       if(rooms!=null){
	        for(Room room : rooms){
	        	if(!frMap.containsKey(room.getFloor())){
	        		List<Room> rs = new ArrayList<Room>();
	        		frMap.put(room.getFloor(), rs);
	        	}
	        	frMap.get(room.getFloor()).add(room);
	        }
	        request.setAttribute("frMap", frMap);
       }
		return "stepSecondUI";
	}
	
	@Action(value = "toThird", results = { @Result(name = "stepThirdUI", location = ViewLocation.View_ROOT
			+ "orderstep2.jsp") })
	public String toThird() throws Exception{
		//TODO 跳转至第三步，订单展示及确认页面
		Customer customer = (Customer)session.get(Const.CUSTOMER);
		String ids = getParameter("ids");
		List<Room> rooms = roomService.getByIds(ids);
		List<Contactors> contactors = contactorsService.getContactorsByCustomerId(customer);
		
		Integer days = (Integer)session.get("days");
		Roomtype roomtype = (Roomtype)session.get("roomtype");
		//需要使用的团购券，放入session
		Integer needVouchers = days*rooms.size();
		pageBean.setPageSize(needVouchers);
		List<Grouppurchasevoucher> vouchers = grouppurchasevoucherService.getByType(customer, roomtype, pageBean);
		session.put("vouchers", vouchers);
		request.setAttribute("total", needVouchers*vouchers.get(0).getPrice());
		
		session.put("rooms", rooms);
		request.setAttribute("contactors", contactors);
		
		return "stepThirdUI";
	}
	
	@Action(value = "addContactor")
	public void addContactor(){
		//TODO 添加联系人,成功返回 1,失败返回0
		try {
			Customer customer = (Customer)session.get(Const.CUSTOMER);
			String	userName = getParameter("name");
			String phoneNumber = getParameter("phone");
			String identityCard =	getParameter("idCard");
			if (contactorsService.isExist(identityCard, customer)) {
				writeStringToResponse("0");
				return ;
			}
			Contactors cont = new Contactors();
			
			cont.setCustomer(customer);
			cont.setIdentityCard(identityCard);
			cont.setName(userName);
			cont.setPhoneNumber(phoneNumber);
			cont.setIsSelf(0);
			Integer id = contactorsService.save(cont);
			writeStringToResponse(id.toString());
		} catch (Exception e) {
			// TODO: handle exception
			writeStringToResponse("0");
		}
	}
	
	@Action(value = "toFourth", results = { @Result(name = "stepFourthUI", location = ViewLocation.View_ROOT
			+ "orderstep3.jsp") })
	public String toFourth() throws Exception{
		//支付押金，跳转至付款页面
		Mrcodeorder order = null;
		if((order=createOrder())!=null){
			request.setAttribute("order", order);
		}else {
			request.setAttribute("msg", "入住订单生成失败，请重新操作");
		}
		
		return "stepFourthUI";
	}
	
	@Action(value = "toFifth", results = { @Result(name = "stepFifthUI", location = ViewLocation.View_ROOT
			+ "orderstep4.jsp") })
	public String toFifth() throws Exception{
		//未支付押金订单生成 
		
		Mrcodeorder order = null;
		if((order=createOrder())!=null){
			for(Password p : order.getPasswords()){
				String msg = "【码团网】"+p.getContactors().getName()+"您好!您已下单成功，日期:"+p.getEstimatedTime().toString().substring(0,10)+
						"，房间:"+p.getRoom().getRoomNumber()+"。酒店正为您办理入住手续，至酒店确认本人身份后，凭房间密码"+p.getPassword()+"即可入住。";
				System.out.println("message:"+msg);
				JSONObject o = JSONObject.fromObject(MessageSend.sendSms(msg, p.getContactors().getPhoneNumber()));
				System.out.println("result:"+o);
			}
			request.setAttribute("msg", "已完成房间入住手续，请至酒店前台核对身份证，并支付押金，即可入住，谢谢！");
		}
		return "stepFifthUI";
	}
	
	public Mrcodeorder createOrder(){
		//生成码团订单
		//收集数据
		try {
			Customer customer = (Customer)session.get(Const.CUSTOMER);
			String roomIds = getParameter("room");
			String contactorIds = getParameter("contactor");
			Date begin = (Date)session.get("begin");
			Date end = (Date)session.get("end");
			List<Grouppurchasevoucher> vouchers = (List<Grouppurchasevoucher>)session.get("vouchers");
			Float depositPrice = (float) 0;
			for(Grouppurchasevoucher g : vouchers){
				depositPrice += g.getPrice();
			}
			//生成订单
			Mrcodeorder mrcodeorder = new Mrcodeorder(customer, 
					MakeOrderNum.makeOrderNum(Thread.currentThread().getName()), 
					depositPrice, new Timestamp(System.currentTimeMillis()), 
					new HashSet<Grouppurchasevoucher>(vouchers));
			mrcodeorder = mrcodeorderService.getById(mrcodeorderService.save(mrcodeorder));
			//把团购券设为已使用
			for(Grouppurchasevoucher voucher : vouchers){
				voucher.setUsed(1);
			}
			grouppurchasevoucherService.saveOrUpdateAll(vouchers);
			//生成各房间的密码钥匙
			List<Password> passwords = null;
			if ((passwords=passwordService.createPasswords(mrcodeorder, roomIds, contactorIds, begin, end))!=null) {
				//请求酒店可用的房间
				String url_str = "http://localhost:8080/JavaPrj_9/reserv.htm?action=createReservBymrcode";//获取用户认证的帐号URL
		        URL url = new URL(url_str);
		        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				// connection.connect();
				// 默认是get 方式
				connection.setRequestMethod("POST");
				// 设置是否向connection输出，如果是post请求，参数要放在http正文内，因此需要设为true
				connection.setDoOutput(true);
				// Post 请求不能使用缓存
				connection.setUseCaches(false);
				//要上传的参数  
				JsonConfig config = new JsonConfig();
				config.setExcludes(new String[] { "roomtype", "floor","roomdates","mrcodeorder","customer"});
				config.registerJsonValueProcessor(Timestamp.class, new JsonValueFormat());
				JSONArray jsonArray = JSONArray.fromObject(passwords,config);
				JSONObject json = new JSONObject();
				json.put("deposit", 0);
				json.put("orderCode", mrcodeorder.getOrderCode());
				json.put("passwords", jsonArray);
		        PrintWriter pw=new PrintWriter(new OutputStreamWriter(connection.getOutputStream(),"utf-8"));
		        String content = "json=" + json;  
		        pw.print(content);
		        pw.flush();
		        pw.close();
		        int code = connection.getResponseCode();
		        if (code == 404) {
		            throw new Exception("连接无效，找不到此次连接的会话信息！");
		        }
		        if (code == 500) {
		            throw new Exception("连接服务器发生内部错误！");
		        }
		        if (code != 200) {
		            throw new Exception("发生其它错误，连接服务器返回 " + code);
		        }
		        InputStream is = connection.getInputStream();
		        byte[] response = new byte[is.available()];
		        is.read(response);
		        is.close();
		        if (response == null || response.length == 0) {
		            throw new Exception("连接无效，找不到此次连接的会话信息！");
		        }
		        mrcodeorder.setPasswords(new HashSet<Password>(passwords));
				return mrcodeorder;
			}else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
}
