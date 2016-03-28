package com.mrcode.dao.impl;

import org.springframework.stereotype.Repository;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.dao.RoomDao;
import com.mrcode.model.Room;

@Repository("roomDaoImpl")
public class RoomDaoImpl extends BaseDaoImpl<Room>
	implements RoomDao{

}