package com.mrcode.dao.impl;

import org.springframework.stereotype.Repository;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.dao.MrcodeorderDao;
import com.mrcode.model.Mrcodeorder;

@Repository("MrcodeorderDaoImpl")
public class MrcodeorderDaoImpl extends BaseDaoImpl<Mrcodeorder>
	implements MrcodeorderDao{

}
