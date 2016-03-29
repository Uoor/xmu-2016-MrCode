package com.mrcode.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Contactors;
import com.mrcode.model.Customer;
import com.mrcode.service.ContactorsService;
import com.mrcode.utils.DataUtils;

@Service
@Transactional
public class ContactorsServiceImpl extends BaseServiceImpl<Contactors> 
	implements ContactorsService{

	@Resource(name="contactorsDaoImpl")
	public void setBaseDao(BaseDaoImpl<Contactors> baseDao){
		super.setBaseDao(baseDao);
	}
	
	public List<Contactors> getContactorsByCustomerId(Customer cus)
	{
		String hql="from Contactors c left join fetch c.customer as cus where cus.id=:id ";
	    
		return this.findByHql(hql, DataUtils.getMap("id",cus.getId()));
	}
}
