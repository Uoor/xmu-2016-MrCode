package com.mrcode.service;

import java.util.Date;
import java.util.List;

import com.mrcode.base.BaseService;
import com.mrcode.model.Mrcodeorder;
import com.mrcode.model.Password;

public interface PasswordService extends BaseService<Password>{

	/**
	 * 生成各房间的密码钥匙并返回
	 * @param mrcodeorder 码团订单
	 * @param roomsIds 预订的房间
	 * @param contactorsIds 对应各房间的联系人
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Password> createPasswords(Mrcodeorder mrcodeorder,
			String roomsIds, String contactorsIds, Date begin, Date end);
	
	public Password getPasswordByPhone(String phoneNumber);
}
