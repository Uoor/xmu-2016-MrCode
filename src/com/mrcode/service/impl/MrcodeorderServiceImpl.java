package com.mrcode.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Mrcodeorder;
import com.mrcode.service.MrcodeorderService;


@Service
@Transactional
public class MrcodeorderServiceImpl extends BaseServiceImpl<Mrcodeorder> 
	implements MrcodeorderService{

	@Resource(name="mrcodeorderDaoImpl")
	public void setBaseDao(BaseDaoImpl<Mrcodeorder> baseDao){
		super.setBaseDao(baseDao);
	}

	public Mrcodeorder getWithContactorsByOrderNum(String orderNum) throws Exception {
		// TODO 根据id获得订单及相关的联系人信息
		String hql = " from Mrcodeorder o left join fetch o.passwords p " +
				" left join fetch p.room left join fetch p.contactors where o.orderCode="+orderNum;
		
		return this.getBaseDao().findUniqueByHql(hql, null);
	}
}