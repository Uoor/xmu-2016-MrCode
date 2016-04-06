package com.mrcode.action.customer;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mrcode.service.CustomerService;
import com.mrcode.service.PasswordService;
import com.mrcode.utils.Const;
import com.mrcode.utils.DigestUtil;
import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.model.Customer;
import com.opensymphony.xwork2.ActionContext;

@Controller
@ParentPackage("customers")
@Namespace("/customer")
public class LoginAction extends BaseAction<Customer>{

	@Autowired
	CustomerService customerService;
	@Autowired
	PasswordService passwordService;
	
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
	@Action(value = "login")
	public String login() throws Exception{
		// 获取数据
		String loginName = getParameter("loginName");
		String password = getParameter("password");
		
		Customer customer = null;
		if((customer = customerService.checkLogin(loginName, DigestUtil.encryptPWD(password)))!=null){
			session.put(Const.CUSTOMER, customer);
			System.out.println("登陆成功");
			
			String ids = passwordService.getLatestCity(customer, pageBean);
			
			return "toIndex";
		} else {
		System.out.println("登陆失败");
		return "toLogin";
		}
	}
	
	/**
	 * 首页
	 * @return
	 */
	@Action(value = "toIndex", results = {
			@Result(name = "index", location = "/WEB-INF/" +"index.jsp")})
	public String index() throws Exception{
	
		return "index";
		}
	
	/**
	 * 动态登陆页面
	 * @return
	 */
	@Action(value = "toLoginPhone", results = {
			@Result(name = "toLoginPhone", location = ViewLocation.View_ROOT +"login_phone.jsp")})
	public String toLoginPhone() throws Exception{
	
		return "toLoginPhone";
		}

}
