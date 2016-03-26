package com.mrcode.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Password;
import com.mrcode.service.PasswordService;

@Service
@Transactional
public class PasswordServiceImpl extends BaseServiceImpl<Password> 
	implements PasswordService{

	@Resource(name="passwordDaoImpl")
	public void setBaseDao(BaseDaoImpl<Password> baseDao){
		super.setBaseDao(baseDao);
	}
}