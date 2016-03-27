package com.mrcode.utils;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mrcode.model.Customer;
import com.mrcode.model.Privilege;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegeInterceptor  extends AbstractInterceptor {
	
	
	
	


	public String intercept(ActionInvocation invocation) throws Exception {
		Customer cus = (Customer) ActionContext.getContext().getSession().get("CheckPrivilegeSession");
			
			String namespace = invocation.getProxy().getNamespace();
			String actionName = invocation.getProxy().getActionName();
			String privUrl = namespace + actionName; // 对应的权限URL
			System.out.println("actionName" + actionName );

		// 如果未登录
				if (cus == null ) {
					if (actionName.startsWith("toLogin") || actionName.startsWith("login" )	)	{ 					
				// 如果是去登录，就放行
						return invocation.invoke();
					} else {
						//如果不是，则转为登陆页面
						return "noPrivilegeError";
						}
				}
				
				
				return invocation.invoke();
				
		
	} //intercept

}//class
