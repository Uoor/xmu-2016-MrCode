package com.mrcode.dao.impl;

import org.springframework.stereotype.Repository;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.dao.PasswordDao;
import com.mrcode.model.Password;

@Repository("PasswordDaoImpl")
public class PasswordDaoImpl extends BaseDaoImpl<Password> implements PasswordDao{

}
