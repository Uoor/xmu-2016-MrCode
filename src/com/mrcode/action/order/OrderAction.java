package com.mrcode.action.order;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.mrcode.utils.DateUtils;
import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.model.Hotel;
import com.mrcode.model.Mrcodeorder;

@ParentPackage("customers")
@Namespace("/order")
public class OrderAction extends BaseAction<Mrcodeorder>{

	@Action(value = "toFirst", results = { @Result(name = "stepFirstUI", location = ViewLocation.View_ROOT
			+ "orderstep0.jsp") })
	public String toFirst() throws Exception{
		//跳转至入住第一步，选择日期页面
		
		//获得房间类型
		Integer typeId = getIntParameter("typeId", -1);
		session.put("typeId", typeId);
		
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
        List<Hotel> hotels = new ArrayList<Hotel>();
        JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("rooms"));
        
		return "stepSecondUI";
	}
}
