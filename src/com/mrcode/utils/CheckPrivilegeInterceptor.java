package com.mrcode.utils;


import javax.swing.Action;

import com.mrcode.common.WebApplication;
import com.mrcode.model.Customer;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CheckPrivilegeInterceptor  extends MethodFilterInterceptor {
	
	
	
	

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		Customer cus = (Customer) WebApplication.getSession().getAttribute(Const.CUSTOMER);
			
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privUrl = namespace + actionName; // 对应的权限URL
		System.out.println("actionName" + " -->" + actionName );

		// 如果未登录
		if (cus == null ) {
			if (actionName.startsWith("toLogin") || actionName.startsWith("login")
					||actionName.startsWith("sendVerification") || actionName.startsWith("mobileLogin") 
					|| actionName.startsWith("updateRoom") || actionName.startsWith("activePassword")
					|| actionName.startsWith("updateRoomInfo") || actionName.startsWith("updateRoomTypeInfo"))		{ 					
		// 如果是去登录，就放行
				return invocation.invoke();
			} else {
				//如果不是，则转为登陆页面
				WebApplication.getResponse().sendRedirect(WebApplication.getRequest().getContextPath()+"/customer/toLogin");
				return null;
			}
		}
		
		
		return invocation.invoke();
				
		
	} //intercept

}//class
