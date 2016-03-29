package com.mrcode.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Roomtype;
import com.mrcode.service.RoomtypeService;

@Service
@Transactional
public class RoomtypeServiceImpl extends BaseServiceImpl<Roomtype> 
	implements RoomtypeService{

	@Resource(name="roomtypeDaoImpl")
	public void setBaseDao(BaseDaoImpl<Roomtype> baseDao){
		super.setBaseDao(baseDao);
	}

	public Roomtype getWithDetail(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		Roomtype type = findUniqueByHql("from Roomtype t left join fetch t.hotel h " +
				"left join fetch t.rooms left join fetch h.floors where t.id=:id"
				, map);
		return type;
	}
}
