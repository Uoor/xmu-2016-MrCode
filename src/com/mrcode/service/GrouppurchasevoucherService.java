package com.mrcode.service;

import java.util.List;

import com.mrcode.base.BaseService;
import com.mrcode.model.Customer;
import com.mrcode.model.Grouppurchasevoucher;
import com.mrcode.model.Roomtype;
import com.mrcode.utils.PageBean;

public interface GrouppurchasevoucherService extends BaseService<Grouppurchasevoucher>{

	/**
	 * 查询本消费者的所有团购券
	 * @param customer 登录的消费者
	 * @return
	 * @throws Exception
	 */
	public List<Grouppurchasevoucher> getByCust(Customer customer) throws Exception;
	
	/**
	 * 查询某房间类型的团购券数量
	 * @param customer
	 * @param typeId 房间类型id
	 * @return
	 * @throws Exception
	 */
	public Integer getTypeCount(Customer customer, Integer typeId) throws Exception;
	
	/**
	 * 取得本用户最快过期的count张某类型团购券
	 * @param customer
	 * @param roomtype
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	public List<Grouppurchasevoucher> getByType(Customer customer,
			Roomtype roomtype, PageBean pageBean) throws Exception;
}
