package com.mrcode.action.customer;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mrcode.service.CustomerService;
import com.mrcode.utils.Const;
import com.mrcode.utils.DigestUtil;
import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.model.Customer;
import com.opensymphony.xwork2.ActionContext;

@Controller
@ParentPackage("customers")
@Namespace("/customer")
public class CustomerAction extends BaseAction<Customer>{

	@Autowired
	CustomerService customerService;
	
	//登录页面
	@Action(value = "toLogin", results = { @Result(name = "loginUI", location = ViewLocation.View_ROOT
			+ "login.jsp") })
	public String toLogin() throws Exception{
		if(ActionContext.getContext().get("msg")!=null)
			request.setAttribute("msg", ActionContext.getContext().get("msg"));
		return "loginUI";
	}
	
	/**
	 * 登录
	 * @return
	 */
	@Action(value = "login", results = { @Result(name = "toLogin", type = TYPE_CHAIN, location = "toLogin"),
			@Result(name = "toIndex", location = ViewLocation.View_ROOT+"hotel.html")})
	public String login() throws Exception{
		// 获取数据
		String loginName = getParameter("loginName");
		String password = getParameter("password");
		
		Customer customer = null;
		if((customer = customerService.checkLogin(loginName, DigestUtil.encryptPWD(password)))!=null){
			session.put(Const.CUSTOMER, customer);
			return "toIndex";
		}
		
		return "toLogin";
	}
}
