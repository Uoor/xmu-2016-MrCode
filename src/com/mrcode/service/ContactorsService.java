package com.mrcode.service;

import java.util.List;

import com.mrcode.base.BaseService;
import com.mrcode.model.Contactors;
import com.mrcode.model.Customer;

public interface ContactorsService extends BaseService<Contactors>{
	public List<Contactors> getContactorsByCustomerId(Customer cus);
}
