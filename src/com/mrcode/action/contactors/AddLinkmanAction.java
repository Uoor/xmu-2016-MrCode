package com.mrcode.action.contactors;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.model.Customer;
import com.mrcode.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;

@Controller
@ParentPackage("customers")
@Namespace("/customer")
public class AddLinkmanAction extends BaseAction<Customer>{
	
	@Autowired
	private CustomerService customerService;
	
	@Action(value = "toAddLinkman", results = { @Result(name = "addLinkmanUI", location = ViewLocation.View_ROOT
			+ "add_friends.jsp") })
	public String addLinkman() throws Exception{
		if(ActionContext.getContext().get("msg")!=null)
			request.setAttribute("msg", ActionContext.getContext().get("msg"));
		
		Customer cus = (Customer) session.get("customer");
		request.setAttribute("userName", cus.getUserName());
		request.setAttribute("phoneNumber",cus.getPhoneNumber());
		
		return "addLinkmanUI";
	}
	

}
