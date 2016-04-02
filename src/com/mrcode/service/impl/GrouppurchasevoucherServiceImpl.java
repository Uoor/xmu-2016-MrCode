package com.mrcode.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Customer;
import com.mrcode.model.Grouppurchasevoucher;
import com.mrcode.model.Roomtype;
import com.mrcode.service.GrouppurchasevoucherService;
import com.mrcode.utils.DateUtils;
import com.mrcode.utils.PageBean;


@Service
@Transactional
public class GrouppurchasevoucherServiceImpl extends BaseServiceImpl<Grouppurchasevoucher> 
	implements GrouppurchasevoucherService{

	@Resource(name="grouppurchasevoucherDaoImpl")
	public void setBaseDao(BaseDaoImpl<Grouppurchasevoucher> baseDao){
		super.setBaseDao(baseDao);
	}

	public List<Grouppurchasevoucher> getByCust(Customer customer)
			throws Exception {
		// TODO 查询本消费者的所有团购券
		String hql = "from Grouppurchasevoucher gp left join fetch gp.roomtype tp " +
				" left join fetch tp.pictures left join fetch tp.hotel where gp.customer=:customer " +
				" and gp.used=0 and gp.expiredTime>:now";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("customer", customer);
		param.put("now", DateUtils.currentTime().toDate());
		List<Grouppurchasevoucher> gps = this.getBaseDao().findByHql(
				hql, param, null, "gp.roomtype, gp.createTime");
		
		return gps;
	}

	public Integer getTypeCount(Customer customer, Integer typeId)
			throws Exception {
		// TODO 查询某房间类型的团购券数量
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customer", customer);
		map.put("id", typeId);
		map.put("now", DateUtils.currentTime().toDate());
		return this.getBaseDao().getCount(" where customer=:customer and used=0 and roomtype.id=:id " +
				" and expiredTime>:now", map);
		
	}

	public List<Grouppurchasevoucher> getByType(Customer customer,
			Roomtype roomtype, PageBean pageBean) throws Exception {
		// TODO 取得本用户最快过期的count张某类型团购券
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customer", customer);
		map.put("roomtype", roomtype);
		map.put("now", DateUtils.currentTime().toDate());
		String hql = "from Grouppurchasevoucher gp where gp.customer=:customer " +
				" and gp.used=0 and gp.expiredTime>:now and gp.roomtype=:roomtype ";
		if (pageBean != null && pageBean.getPageNum() == 0) {
			pageBean.setDataSize(this.getBaseDao().getCount(" where customer=:customer and used=0" +
					" and expiredTime>:now and roomtype=:roomtype",map));
		}
		List<Grouppurchasevoucher> vouchers = findByHql(hql, map, pageBean, "gp.expiredTime");
		return vouchers;
	}
	
	
}