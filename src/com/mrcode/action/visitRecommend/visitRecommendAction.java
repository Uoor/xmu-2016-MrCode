package com.mrcode.action.visitRecommend;

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
public class visitRecommendAction extends BaseAction<Customer>{

	
	@Action(value="toVisitRecommend", 
			results={@Result(name="visiting_business_high", location=ViewLocation.View_ROOT+
			"visiting_business_high.jsp"),
			@Result(name="visiting_business_low", location=ViewLocation.View_ROOT+
					"visiting_business_low.jsp"),
					@Result(name="visiting_visitor_high", location=ViewLocation.View_ROOT+
							"visiting_visitor_high.jsp"),
							@Result(name="visiting_visitor_low", location=ViewLocation.View_ROOT+
									"visiting_visitor_low.jsp")})
	public String toVisitRecommend() throws Exception{
		//TODO 跳转到交通推荐的页面
		
	
		Customer cus = (Customer) session.get("customer");
		int cusType = cus.getCusType();
		int shopLevel = cus.getShopLevel();
		int result = Recommend.recomendInt(cusType,shopLevel);
		System.out.println("result" + result);
		if (result == 1)
			return "visiting_business_high";
		else if (result == 2)
			return "visiting_business_low";	
		else if (result == 3)
			return "visiting_visitor_high";		
		else if (result == 4)
			return "visiting_visitor_low";
		
		return "traffic_visitor_low";
	}
}
