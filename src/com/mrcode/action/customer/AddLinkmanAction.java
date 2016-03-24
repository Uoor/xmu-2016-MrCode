package com.mrcode.action.customer;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.model.Customer;
import com.opensymphony.xwork2.ActionContext;

@Controller
@ParentPackage("customers")
@Namespace("/customer")
public class AddLinkmanAction extends BaseAction<Customer>{
	
	//登录页面
	@Action(value = "toLogin", results = { @Result(name = "loginUI", location = ViewLocation.View_ROOT
			+ "login.jsp") })
	public String toLogin() throws Exception{
		if(ActionContext.getContext().get("msg")!=null)
			request.setAttribute("msg", ActionContext.getContext().get("msg"));
		return "loginUI";
	}

}
