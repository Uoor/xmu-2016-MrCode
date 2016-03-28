package com.mrcode.dao.impl;

import org.springframework.stereotype.Repository;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.dao.FloorDao;
import com.mrcode.model.Floor;

@Repository("floorDaoImpl")
public class FloorDaoImpl extends BaseDaoImpl<Floor>
	implements FloorDao{

}