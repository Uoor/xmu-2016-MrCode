package com.mrcode.action.index;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.model.Customer;
import com.mrcode.model.Grouppurchasevoucher;
import com.mrcode.model.Roomtype;
import com.mrcode.service.GrouppurchasevoucherService;
import com.mrcode.utils.Const;

@Controller
@ParentPackage("customers")
@Namespace("/customer")
public class IndexAction extends BaseAction<Customer>{

	@Autowired
	GrouppurchasevoucherService grouppurchasevoucherService;
	
	@Action(value="toOrder", results={@Result(name="orderUI", location=ViewLocation.View_ROOT+
			"hotel.jsp")})
	public String toOrder() throws Exception{
		//TODO 跳转到选择团购券的页面
		Customer customer = (Customer)session.get(Const.CUSTOMER);
		List<Grouppurchasevoucher> gps = grouppurchasevoucherService.getByCust(customer);
		
		//把数据封装成Map
		Map<Roomtype, List<Grouppurchasevoucher>> rgMap = new LinkedHashMap<Roomtype, List<Grouppurchasevoucher>>();
		for(Grouppurchasevoucher gp : gps){
			if(!rgMap.containsKey(gp.getRoomtype())){
				List<Grouppurchasevoucher> grps = new LinkedList<Grouppurchasevoucher>();
				rgMap.put(gp.getRoomtype(), grps);
			}
			rgMap.get(gp.getRoomtype()).add(gp);
		}
		
		request.setAttribute("rgMap", rgMap);
		
		return "orderUI";
	}
	
	
	@Action(value="toAboutus", results={@Result(name="aboutus", location=ViewLocation.View_ROOT+
			"aboutus.jsp")})
	public String toAboutus() throws Exception{
		
		return "aboutus";
	}
}
