package com.mrcode.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Contactors;
import com.mrcode.model.Mrcodeorder;
import com.mrcode.model.Password;
import com.mrcode.model.Room;
import com.mrcode.service.ContactorsService;
import com.mrcode.service.PasswordService;
import com.mrcode.service.RoomService;

@Service
@Transactional
public class PasswordServiceImpl extends BaseServiceImpl<Password> 
	implements PasswordService{

	@Autowired
	RoomService roomService;
	@Autowired
	ContactorsService contactorsService;
	
	@Resource(name="passwordDaoImpl")
	public void setBaseDao(BaseDaoImpl<Password> baseDao){
		super.setBaseDao(baseDao);
	}

	public List<Password> createPasswords(Mrcodeorder mrcodeorder, String roomsIds,
			String contactorsIds, Date begin, Date end) {
		// TODO 生成各房间的密码钥匙
		try {
			String[] roomsStrings = roomsIds.split(",");
			String[] contactorsIdsStrings = contactorsIds.split(",");
			if (roomsStrings.length != contactorsIdsStrings.length) {
				return null;
			}
			List<Password> passwords = new ArrayList<Password>();
			for(int i=0; i<roomsStrings.length; i++){
				Room room = roomService.getById(Integer.parseInt(roomsStrings[i]));
				Contactors contactor = contactorsService.getById(Integer.parseInt(contactorsIdsStrings[i]));
				Random random = new Random();
				String code = "";
				for(int j=0; j<6; j++){
					code += random.nextInt(10);
				}
				Password password = new Password(room, mrcodeorder, 
						new Timestamp(System.currentTimeMillis()), 
						code, new Timestamp(begin.getTime()), new Timestamp(end.getTime()),contactor);
				this.getBaseDao().save(password);
				passwords.add(password);
			}
			
			return passwords;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public Password getPasswordByPhone(String phoneNumber) {
		//TODO 通过password表的isValid=1 和
	    //    ContactId.phoneNumber == 参数phoneNumber 得到password对象
		String hql = "from Password p left join fetch p.contactors as cont left join fetch p.room "
				+ "where p.isValid = 1 and cont.phoneNumber =:phoneNumber ";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phoneNumber", phoneNumber);
		Password passwd = findUniqueByHql(hql, map);
		
		return passwd;
	}

	
}