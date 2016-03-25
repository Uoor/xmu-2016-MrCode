package com.mrcode.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Floor;
import com.mrcode.service.FloorService;

@Service
@Transactional
public class FloorServiceImpl extends BaseServiceImpl<Floor> 
	implements FloorService{

	@Resource(name="floorDaoImpl")
	public void setBaseDao(BaseDaoImpl<Floor> baseDao){
		super.setBaseDao(baseDao);
	}
}
