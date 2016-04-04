package com.mrcode.service.impl;

import java.util.HashMap;
import java.util.List;
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

	public List<Room> getByRoomNumAndType(String roomNums, Roomtype type)
			throws Exception {
		// TODO 通过房间号和酒店获得房间
		if(roomNums!=null && !roomNums.equals("")){
			String hql = "from Room r left join fetch r.roomtype left join fetch r.floor " +
					" where r.roomNumber in ("+roomNums+") and r.roomtype=:type";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", type);
			List<Room> rooms = findByHql(hql, map);
			return rooms;
		}else
			return null;
		
	}

	public List<Room> getByIds(String ids) throws Exception {
		// TODO 根据房间id获得多个房间
		if (ids==null || ids.replaceAll(" ", "").equals("")) {
			return null;
		}
		String hql = "from Room r left join fetch r.roomtype where r.id in (" + ids + ")";
		
		return this.getBaseDao().findByHql(hql, new HashMap<String, Object>(), null, "r.id");
	}
	
}
