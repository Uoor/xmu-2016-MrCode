package com.mrcode.service;

import com.mrcode.base.BaseService;
import com.mrcode.model.Roomtype;

public interface RoomtypeService extends BaseService<Roomtype>{

	/**
	 * id
	 * @return
	 * @throws Exception
	 */
	public Roomtype getWithDetail(Integer id)throws Exception;
	public Roomtype findRoomtypeByTypeId(Integer hotelid, String typeid) throws Exception;
}
