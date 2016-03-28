package com.mrcode.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Room;
import com.mrcode.service.RoomService;

@Service
@Transactional
public class RoomServiceImpl extends BaseServiceImpl<Room> 
	implements RoomService{

	@Resource(name="roomDaoImpl")
	public void setBaseDao(BaseDaoImpl<Room> baseDao){
		super.setBaseDao(baseDao);
	}
}
