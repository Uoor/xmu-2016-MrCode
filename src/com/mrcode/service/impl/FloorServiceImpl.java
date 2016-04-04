package com.mrcode.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Customer;
import com.mrcode.model.Floor;
import com.mrcode.model.Grouppurchasevoucher;
import com.mrcode.model.Hotel;
import com.mrcode.model.Roomtype;
import com.mrcode.service.FloorService;
import com.mrcode.utils.DateUtils;
import com.mrcode.utils.PageBean;

@Service
@Transactional
public class FloorServiceImpl extends BaseServiceImpl<Floor> 
	implements FloorService{

	@Resource(name="floorDaoImpl")
	public void setBaseDao(BaseDaoImpl<Floor> baseDao){
		super.setBaseDao(baseDao);
	}
	
	public Floor findFloorByHotelAndFloornum(Integer hotelId, Integer floorid) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hotelId", hotelId);
		map.put("floorid", floorid);
		String hql = "from Floor fl where fl.hotel.id=:hotelId and fl.floorNumber=:floorid";
		return this.findUniqueByHql(hql, map);
	}
}
