package com.mrcode.action.order;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.mrcode.service.GrouppurchasevoucherService;
import com.mrcode.service.RoomService;
import com.mrcode.service.RoomtypeService;
import com.mrcode.utils.Const;
import com.mrcode.utils.DateUtils;
import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.common.WebApplication;
import com.mrcode.model.Customer;
import com.mrcode.model.Floor;
import com.mrcode.model.Mrcodeorder;
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
	
	@Action(value = "toFirst", results = { @Result(name = "stepFirstUI", location = ViewLocation.View_ROOT
			+ "orderstep0.jsp") })
	public String toFirst() throws Exception{
		//跳转至入住第一步，选择日期页面
		
		Customer customer = (Customer)session.get(Const.CUSTOMER);
		//获得房间类型
		Integer typeId = getIntParameter("typeId", -1);
		Integer validCount = grouppurchasevoucherService.getTypeCount(customer, typeId);
		session.put("typeId", typeId);
		session.put("validCount", validCount);
		
		return "stepFirstUI";
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
		session.put("begin", begin);
		session.put("end", end);
		
		Integer typeId = null;
		//查询所订房间类型的具体信息
		try {
			typeId = (Integer)session.get("typeId");
		} catch (Exception e) {
			// TODO: 未选择团购券,跳转到选择团购券页面
			WebApplication.getResponse().sendRedirect(WebApplication.getRequest().getContextPath()+"/customer/toOrder");
		}
		
		Roomtype roomtype = roomtypeService.getWithDetail(typeId);
		
		//请求酒店可用的房间
		String url_str = "http://localhost:8080/JavaPrj_9/reserv.htm?action=findAvailRoomsInJson";//获取用户认证的帐号URL
        URL url = new URL(url_str);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();

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
        List<Room> rooms = new ArrayList<Room>();
        JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("rooms"));
        //把获得的json组装成对象
        for(Object object : jsonArray){
        	Room room = roomService.getByRoomNumAndType(((JSONObject)object).getString("rmId"), roomtype);
        	if (room!=null) {
        		room.setState(((JSONObject)object).getInt("rmState"));
    			rooms.add(room);
			}
        	
        }
        //把楼层和房间变成map
        Map<Floor, List<Room>> frMap = new LinkedHashMap<Floor, List<Room>>();
        for(Room room : rooms){
        	if(!frMap.containsKey(room.getFloor())){
        		List<Room> rs = new ArrayList<Room>();
        		frMap.put(room.getFloor(), rs);
        	}
        	frMap.get(room.getFloor()).add(room);
        }
        request.setAttribute("frMap", frMap);
        
		return "stepSecondUI";
	}
	
	@Action(value = "toThird", results = { @Result(name = "stepThirdUI", location = ViewLocation.View_ROOT
			+ "orderstep2.jsp") })
	public String toThird() throws Exception{
		
		
		
		return "stepThirdUI";
	}
	
	@Action(value = "toFourth", results = { @Result(name = "stepFourthUI", location = ViewLocation.View_ROOT
			+ "orderstep3.jsp") })
	public String toFourth() throws Exception{
		
		return "stepFourthUI";
	}
	
	@Action(value = "toFifth", results = { @Result(name = "stepFifthUI", location = ViewLocation.View_ROOT
			+ "orderstep4.jsp") })
	public String toFifth() throws Exception{
		
		return "stepFifthUI";
	}
}
