package com.mrcode.dao.impl;

import org.springframework.stereotype.Repository;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.dao.ContactorsDao;
import com.mrcode.model.Contactors;

@Repository("contactorsDaoImpl")
public class ContactorsDaoImpl extends BaseDaoImpl<Contactors>
	implements ContactorsDao{

}
