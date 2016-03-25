package com.mrcode.action.index;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.model.Customer;
import com.mrcode.service.GrouppurchasevoucherService;
import com.mrcode.utils.Const;

@Controller
@Namespace("/")
public class IndexAction extends BaseAction<Customer>{

	@Autowired
	GrouppurchasevoucherService grouppurchasevoucherService;
	
	@Action(value="toOrder", results={@Result(name="orderUI", location=ViewLocation.View_ROOT+
			"hotel.jsp")})
	public String toOrder() throws Exception{
		
		Customer customer = (Customer)session.get(Const.CUSTOMER);
		request.setAttribute("groupPurchases", grouppurchasevoucherService.getByCust(customer));
		
		return "orderUI";
	}
}
