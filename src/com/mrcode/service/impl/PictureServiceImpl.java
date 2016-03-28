package com.mrcode.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Picture;
import com.mrcode.service.PictureService;

@Service
@Transactional
public class PictureServiceImpl extends BaseServiceImpl<Picture> 
	implements PictureService{

	@Resource(name="pictureDaoImpl")
	public void setBaseDao(BaseDaoImpl<Picture> baseDao){
		super.setBaseDao(baseDao);
	}
}
