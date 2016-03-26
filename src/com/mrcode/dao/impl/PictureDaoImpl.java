package com.mrcode.dao.impl;

import org.springframework.stereotype.Repository;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.dao.PictureDao;
import com.mrcode.model.Picture;

@Repository("pictureDaoImpl")
public class PictureDaoImpl extends BaseDaoImpl<Picture> implements PictureDao{

}
