package com.mrcode.action.contactors;

import java.util.List;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.model.Contactors;
import com.mrcode.model.Customer;
import com.mrcode.service.ContactorsService;
import com.mrcode.service.CustomerService;
import com.mrcode.utils.DataUtils;
import com.opensymphony.xwork2.ActionContext;

@Controller
@ParentPackage("customers")
@Namespace("/customer")
public class AddLinkmanAction extends BaseAction<Contactors>{
	
	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private ContactorsService contactorsService;
	
	@Action(value = "toAddLinkman", results = { @Result(name = "addLinkmanUI", location = ViewLocation.View_ROOT
			+ "add_friends.jsp") })
	public String toAddLinkman() throws Exception{
		if(ActionContext.getContext().get("msg")!=null)
			request.setAttribute("msg", ActionContext.getContext().get("msg"));
		
		Customer cus = (Customer) session.get("customer");
		
		List<Contactors> contsList=  contactorsService.getContactorsByCustomerId(cus);
		
		request.setAttribute("contsList", contsList);
		
		return "addLinkmanUI";
	}
	
	@Action (value = "editLinkman" ,results = {@Result(name = "editLinkman" ,  type = TYPE_REDIRECT_ACTION,location= "toAddLinkman" )})
	public String editLinkeman() throws Exception {
		
		int id  = getIntParameter("id", -1);
		Contactors cont = contactorsService.getById(id);
		String name  = getParameter("name");
		String phoneNumber  = getParameter("phoneNumber");
		String identityCard  = getParameter("identityCard");
		System.out.println(name + phoneNumber + identityCard);
		cont.setIdentityCard(identityCard);
		cont.setName(name);
		cont.setPhoneNumber(phoneNumber);
		
		contactorsService.update(cont);
		
		return "editLinkman";
	}
	
	
	@Action (value = "delLinkman" ,results = {@Result(name = "delLinkman" , type = TYPE_REDIRECT_ACTION,location= "toAddLinkman" )})
	public String delLinkman() throws Exception {
		
		int i  = getIntParameter("id",-1);
		
		
		
		contactorsService.remove(i);
		
		return "delLinkman";
	}
	
	
	@Action (value= "addLinkman" , results = {@Result(name ="toAddLinkman", type = TYPE_REDIRECT_ACTION,location= "toAddLinkman" )})
	public String addLinkman() throws Exception {
		
		String	userName = getParameter("userName");
		String phoneNumber = getParameter("phoneNumber");
		String identityCard =	getParameter("identityCard");
		
		System.out.println(userName + phoneNumber + identityCard);
		Contactors cont = new Contactors();
		
		Customer cus = (Customer)session.get("customer");
		cont.setCustomer(cus);
		cont.setIdentityCard(identityCard);
		cont.setName(userName);
		cont.setPhoneNumber(phoneNumber);
		contactorsService.save(cont);
		
		return "toAddLinkman";
		
	}
	
}
