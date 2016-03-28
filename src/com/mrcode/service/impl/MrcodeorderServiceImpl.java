package com.mrcode.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Mrcodeorder;
import com.mrcode.service.MrcodeorderService;


@Service
@Transactional
public class MrcodeorderServiceImpl extends BaseServiceImpl<Mrcodeorder> 
	implements MrcodeorderService{

	@Resource(name="mrcodeorderDaoImpl")
	public void setBaseDao(BaseDaoImpl<Mrcodeorder> baseDao){
		super.setBaseDao(baseDao);
	}
}