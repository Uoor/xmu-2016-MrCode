package com.mrcode.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Grouppurchasevoucher;
import com.mrcode.service.GrouppurchasevoucherService;


@Service
@Transactional
public class GrouppurchasevoucherServiceImpl extends BaseServiceImpl<Grouppurchasevoucher> 
	implements GrouppurchasevoucherService{

	@Resource(name="grouppurchasevoucherDaoImpl")
	public void setBaseDao(BaseDaoImpl<Grouppurchasevoucher> baseDao){
		super.setBaseDao(baseDao);
	}
}