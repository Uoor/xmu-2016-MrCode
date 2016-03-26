package com.mrcode.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Roomtype;
import com.mrcode.service.RoomtypeService;

@Service
@Transactional
public class RoomtypeServiceImpl extends BaseServiceImpl<Roomtype> 
	implements RoomtypeService{

	@Resource(name="roomtypeDaoImpl")
	public void setBaseDao(BaseDaoImpl<Roomtype> baseDao){
		super.setBaseDao(baseDao);
	}
}
