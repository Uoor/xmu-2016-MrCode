package com.mrcode.service;

import java.util.List;

import com.mrcode.base.BaseService;
import com.mrcode.model.Contactors;
import com.mrcode.model.Customer;

public interface ContactorsService extends BaseService<Contactors>{
	//订房间时添加联系人=本人+未删除联系人
	public List<Contactors> getContactorsByCustomerId(Customer cus);
	//管理联系人=未删除联系人
	public List<Contactors> getContactorsByCustomerIds(Customer cus);
}
