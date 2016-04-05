package com.mrcode.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Contactors;
import com.mrcode.model.Customer;
import com.mrcode.service.ContactorsService;
import com.mrcode.utils.DataUtils;

@Service
@Transactional
public class ContactorsServiceImpl extends BaseServiceImpl<Contactors> 
	implements ContactorsService{

	@Resource(name="contactorsDaoImpl")
	public void setBaseDao(BaseDaoImpl<Contactors> baseDao){
		super.setBaseDao(baseDao);
	}
	
	//订房间时添加联系人=本人+未删除联系人
	public List<Contactors> getContactorsByCustomerId(Customer cus)
	{
		String hql="from Contactors c left join fetch c.customer where c.customer=:cus and c.isSelf != 2";
	    
		return this.findByHql(hql, DataUtils.getMap("cus",cus));
	}
	//管理联系人=未删除联系人
	public List<Contactors> getContactorsByCustomerIds(Customer cus)
	{
		String hql="from Contactors c left join fetch c.customer where c.customer=:cus and c.isSelf = 0";
	    
		return this.findByHql(hql, DataUtils.getMap("cus",cus));
	}

	public Boolean isExist(String idCardNum, Customer customer) throws Exception {
		// TODO 判断此身份证是否已存在
		Map<String, Object> param = new HashMap<String, Object>();
		if(idCardNum==null || idCardNum.equals(""))
			return false;
		param.put("customer", customer);
		Integer count = this.getBaseDao().getCount(" where identityCard='"+idCardNum+"' and customer=:customer " +
				" and isSelf<>2", param);
		if(count>0){
			return true;
		}
		return false;
	}
}
