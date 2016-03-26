package com.mrcode.dao.impl;

import org.springframework.stereotype.Repository;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.dao.HotelDao;
import com.mrcode.model.Hotel;

@Repository("hotelDaoImpl")
public class HotelDaoImpl extends BaseDaoImpl<Hotel>
	implements HotelDao{

}
