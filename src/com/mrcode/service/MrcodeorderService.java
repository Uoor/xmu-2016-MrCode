package com.mrcode.service;

import java.util.List;

import com.mrcode.base.BaseService;
import com.mrcode.model.Customer;
import com.mrcode.model.Grouppurchasevoucher;
import com.mrcode.model.Mrcodeorder;

public interface MrcodeorderService extends BaseService<Mrcodeorder>{

	/**
	 * 根据订单号获得订单及相关的联系人信息
	 * @param orderNum
	 * @return
	 * @throws Exception
	 */
	public Mrcodeorder getWithContactorsByOrderNum(String orderNum) throws Exception;
}
