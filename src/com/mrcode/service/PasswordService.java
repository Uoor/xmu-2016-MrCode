package com.mrcode.service;

import java.util.Date;
import java.util.List;

import com.mrcode.base.BaseService;
import com.mrcode.model.Customer;
import com.mrcode.model.Mrcodeorder;
import com.mrcode.model.Password;
import com.mrcode.utils.PageBean;

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
	
	/**
	 * 查询本用户最近五次出行的城市，如无数据，则以0填充，倒序排列
	 * @param customer
	 * @param pageBean size设为5
	 * @return
	 * @throws Exception
	 */
	public String getLatestCity(Customer customer, PageBean pageBean) throws Exception;
/**
	 * 激活相应的房间钥匙
	 * @param roomId
	 * @throws Exception
	 */
	public void active(String roomId) throws Exception;public int getShopLevel(Customer customer, PageBean pageBean) throws Exception;}
