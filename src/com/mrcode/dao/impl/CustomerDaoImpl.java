package com.mrcode.dao.impl;

import org.springframework.stereotype.Repository;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.dao.CustomerDao;
import com.mrcode.model.Customer;

@Repository("customerDaoImpl")
public class CustomerDaoImpl extends BaseDaoImpl<Customer>
	implements CustomerDao{

}
