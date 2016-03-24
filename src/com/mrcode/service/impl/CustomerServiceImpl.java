package com.mrcode.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Customer;
import com.mrcode.service.CustomerService;
import com.mrcode.utils.DataUtils;

@Transactional
@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer>
	implements CustomerService{

	@Resource(name="customerDaoImpl")
	public void setBaseDao(BaseDaoImpl<Customer> baseDao){
		super.setBaseDao(baseDao);
	}

	// 判断用户名密码正确，同时用户已通过审核，才能取出该用户
	public Customer checkLogin(String field, String password) throws Exception {
		try {
			Customer user = (Customer) findUniqueByHql(
					"from Customer u where u.password=:password",DataUtils.getMap(
							"password", password));
					/*"from Customer u where u.password=:password and " +
					"(u.phoneNumber=:phone or u.email=:email or u.userName=:userName)",
					DataUtils.getMap("password", password,
							"phone", field, "email", field,
							"userName", field));*/	
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
