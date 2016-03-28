package com.mrcode.service;

import java.util.List;

import com.mrcode.base.BaseService;
import com.mrcode.model.Customer;
import com.mrcode.model.Grouppurchasevoucher;

public interface GrouppurchasevoucherService extends BaseService<Grouppurchasevoucher>{

	/**
	 * 查询本消费者的所有团购券
	 * @param customer 登录的消费者
	 * @return
	 * @throws Exception
	 */
	public List<Grouppurchasevoucher> getByCust(Customer customer) throws Exception;
}
