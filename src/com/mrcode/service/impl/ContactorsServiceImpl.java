package com.mrcode.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Contactors;
import com.mrcode.service.ContactorsService;

@Service
@Transactional
public class ContactorsServiceImpl extends BaseServiceImpl<Contactors> 
	implements ContactorsService{

	@Resource(name="contactorsDaoImpl")
	public void setBaseDao(BaseDaoImpl<Contactors> baseDao){
		super.setBaseDao(baseDao);
	}
}
