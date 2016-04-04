package com.mrcode.action.logout;


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
public class LogoutAction extends BaseAction<Customer>{

	@Autowired
	CustomerService customerService;
	
	/**
	 * 退出
	 * 
	 * @return
	 */
	@Action(value = "logout")
	public String logout() throws Exception {
		System.out.println("CustomerAction.logout()");
		//从session中拿到customer
		Customer customer = (Customer) session.get("customer");
		session.remove("customer");
			return "toLogin";
	}


}
