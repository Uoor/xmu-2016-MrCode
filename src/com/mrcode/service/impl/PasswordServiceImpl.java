package com.mrcode.service.impl;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.base.BaseDaoImpl;
import com.mrcode.base.BaseServiceImpl;
import com.mrcode.model.Contactors;
import com.mrcode.model.Customer;
import com.mrcode.model.Hotel;
import com.mrcode.model.Mrcodeorder;
import com.mrcode.model.Password;
import com.mrcode.model.Room;
import com.mrcode.service.ContactorsService;
import com.mrcode.service.PasswordService;
import com.mrcode.service.RoomService;
import com.mrcode.utils.DateUtils;
import com.mrcode.utils.PageBean;

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

	public String getLatestCity(Customer customer, PageBean pageBean) throws Exception {
		// TODO 查询本用户最近五次出行的城市，如无数据，则以1填充，倒序排列
		pageBean.setPageSize(5);
		pageBean.setPageSize(10);
		String hql = "from Password p left join fetch p.room r left join fetch r.roomtype t" +
				" left join fetch t.hotel where p.contactors.identityCard=:idCard ";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idCard", customer.getIdentityCard());
		List<Password> passwords = this.findByHql(hql, map, pageBean, "p.estimatedTime desc");
		String ids = "";
		int  k = 0;
		//passwords 超过5 只取5个,不取重复数据
		Set<Hotel> hotel = new HashSet<Hotel>();
		for(Password password : passwords){
			if (k == 5) break;
			hotel.add(password.getRoom().getRoomtype().getHotel());
			// ids += password.getRoom().getRoomtype().getHotel().getAddressRemark()+",";
			k ++;
		}
		int j = hotel.size();
		for (int i = 1;i <= j ; i++) {
			ids += (i + ",");
		}
		//不足5个，补1 
		for(int i=5 - j;i > 0; --i){
			ids += "1,";
		}
		if(ids.endsWith(",")){
			ids = ids.substring(0, ids.length()-1);
		}
		return ids;
	}
	
	
	public int getShopLevel(Customer customer, PageBean pageBean) throws Exception {
		// TODO 查询本用户最近五次出行的城市，如无数据，则以1填充，倒序排列
		pageBean.setPageSize(5);
		pageBean.setPageSize(10);
		String hql = "from Password p left join fetch p.room r left join fetch r.roomtype t " +
				"where p.contactors.identityCard=:idCard ";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idCard", customer.getIdentityCard());
		List<Password> passwords = this.findByHql(hql, map, pageBean, "p.estimatedTime desc");
		Float sum = (float) 0;
		int ave = 0;
		if ( passwords.size()!=0 ) {
		for(Password password : passwords){
			 sum += password.getRoom().getRoomtype().getPrice();
		}
		
		ave = (int) (sum/ passwords.size());
		}
		
		return ave;
	}

	public void active(String roomId) throws Exception {
		// TODO 激活相应的房间钥匙
		String hql = "from Password p where p.room.roomNumber=:roomId " +
				" and ( p.isValid=0 or p.isValid is null)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roomId", roomId);
		Password password = this.getBaseDao().findUniqueByHql(hql, map);
		if(password!=null){
			password.setIsValid(1);
		}
	}

	public Boolean checkIDCard(String IDNum, Date begin, Date end)
			throws Exception {
		// TODO  判断此身份证号是否在相应的时段已预定了房间,已预定返回false,未预定返回true
		String hql = "from Password p where p.contactors.identityCard=:IDNum and p.estimatedTime<:end and p.endTime>:begin " ;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("IDNum", IDNum);
		map.put("end", end);
		map.put("begin", begin);
		List<Password> passwords = this.getBaseDao().findByHql(hql, map, null, null);
		if(passwords==null || passwords.isEmpty())
			return true;
		else return false;
	}

	
}