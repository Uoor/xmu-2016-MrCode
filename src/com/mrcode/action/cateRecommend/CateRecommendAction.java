package com.mrcode.action.cateRecommend;

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
import com.mrcode.utils.Recommend;

@Controller
@ParentPackage("customers")
@Namespace("/customer")
public class CateRecommendAction extends BaseAction<Customer>{

	
	@Action(value="toCateRecommend", 
			results={@Result(name="restaurant_business_high", location=ViewLocation.View_ROOT+
			"restaurant_business_high.jsp"),
			@Result(name="restaurant_business_low", location=ViewLocation.View_ROOT+
					"restaurant_business_low.jsp"),
					@Result(name="restaurant_visitor_high", location=ViewLocation.View_ROOT+
							"restaurant_visitor_high.jsp"),
							@Result(name="restaurant_visitor_low", location=ViewLocation.View_ROOT+
									"restaurant_visitor_low.jsp")})
	public String toCateRecommend() throws Exception{
		//TODO 跳转到美食推荐的页面
		
	
		Customer cus = (Customer) session.get("customer");
		int cusType = cus.getCusType();
		int shopLevel = cus.getShopLevel();
		int result = Recommend.recomendInt(cusType,shopLevel);
		System.out.println("result" + result);
		if (result == 1)
			return "restaurant_business_high";
		else if (result == 2)
			return "restaurant_business_low";	
		else if (result == 3)
			return "restaurant_visitor_high";		
		else if (result == 4)
			return "restaurant_visitor_low";
		
		return "restaurant_visitor_low";
	}
}
