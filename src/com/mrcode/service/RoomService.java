package com.mrcode.service;

import com.mrcode.base.BaseService;
import com.mrcode.model.Hotel;
import com.mrcode.model.Room;
import com.mrcode.model.Roomtype;

public interface RoomService extends BaseService<Room>{

	/**
	 * 通过房间号和房间类型获得房间
	 * @param roomNum
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public Room getByRoomNumAndType(String roomNum, Roomtype type) throws Exception;
}
