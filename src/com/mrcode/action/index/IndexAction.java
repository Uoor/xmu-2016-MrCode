package com.mrcode.action.index;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.model.Customer;

@Controller
@Namespace("/")
public class IndexAction extends BaseAction<Customer>{

	@Action(value="toOrder", results={@Result(name="orderUI", location=ViewLocation.View_ROOT+
			"hotel.jsp")})
	public String toOrder(){
		
		return "orderUI";
	}
}
