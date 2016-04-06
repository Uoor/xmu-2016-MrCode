package com.mrcode.action.order;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.mrcode.base.BaseAction;
import com.mrcode.model.Password;

@ParentPackage("customers")
@Namespace("/room")
public class ConfirmOrderAction extends BaseAction<Password>{

	
	
	@Action(value="activePassword")
	public void activePassword() throws Exception {
		//TODO 确定房间入住，激活密码
		try {
			String rooms = getParameter("rooms");
	        JSONArray jsonArray = JSONArray.fromObject(rooms);
	        String roomId = ((JSONObject)jsonArray.get(0)).getString("rmId");
	        
		} catch (Exception e) {
			// TODO: 房间密码激活失败
			
		}
		
        
	}
}
