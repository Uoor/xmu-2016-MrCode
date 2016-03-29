package com.mrcode.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Hotel;
import com.mrcode.service.HotelService;


@Service
@Transactional
public class HotelServiceImpl extends BaseServiceImpl<Hotel> 
	implements HotelService{

	@Resource(name="hotelDaoImpl")
	public void setBaseDao(BaseDaoImpl<Hotel> baseDao){
		super.setBaseDao(baseDao);
	}

}