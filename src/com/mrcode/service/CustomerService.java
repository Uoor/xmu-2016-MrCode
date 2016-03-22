package com.mrcode.service;

import com.mrcode.base.BaseService;
import com.mrcode.model.Customer;

public interface CustomerService extends BaseService<Customer>{

	/**
	 * 根据电话号码、邮箱或用户名进行登录
	 * @param field		字段名
	 * @param password	密码	
	 * @return
	 */
	public Customer checkLogin(String field, String password) throws Exception;
}
