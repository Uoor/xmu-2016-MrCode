package com.mrcode.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Hotel;
import com.mrcode.model.Room;
import com.mrcode.model.Roomtype;
import com.mrcode.service.RoomService;

@Service
@Transactional
public class RoomServiceImpl extends BaseServiceImpl<Room> 
	implements RoomService{

	@Resource(name="roomDaoImpl")
	public void setBaseDao(BaseDaoImpl<Room> baseDao){
		super.setBaseDao(baseDao);
	}

	public Room getByRoomNumAndType(String roomNum, Roomtype type)
			throws Exception {
		// TODO 通过房间号和酒店获得房间
		String hql = "from Room r left join fetch r.roomtype left join fetch r.floor " +
				" where r.roomNumber=:roomNum and r.roomtype=:type";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("roomNum", roomNum);
		Room room = findUniqueByHql(hql, map);
		return room;
	}
}
