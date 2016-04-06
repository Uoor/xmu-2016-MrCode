package com.mrcode.action.order;

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
		String roomNum = getParameter("roomId");
		
	}
}
