package com.mrcode.service;

import com.mrcode.base.BaseService;
import com.mrcode.model.Floor;
import com.mrcode.model.Hotel;

public interface FloorService extends BaseService<Floor>{
	public Floor findFloorByHotelAndFloornum(Integer hotelId, Integer floorid) throws Exception;
}
