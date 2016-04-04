package com.mrcode.action.roomManage;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.model.Customer;
import com.mrcode.model.Password;
import com.mrcode.model.Room;
import com.mrcode.service.PasswordService;
import com.mrcode.service.RoomService;
import com.opensymphony.xwork2.ActionContext;

@Controller
@ParentPackage("customers")
@Namespace("/customer")
public class RoomManageAction extends BaseAction<Room>{
	
	
	@Autowired
	private PasswordService passwordService;
	
	@Autowired
	private RoomService roomService;
	
	//登录页面
		@Action(value = "toRoomManage", results = { @Result(name = "toRoomManage", location = ViewLocation.View_ROOT
				+ "management.jsp") })
		public String toRoomManage() throws Exception{
			if(ActionContext.getContext().get("msg")!=null)
				request.setAttribute("msg", ActionContext.getContext().get("msg"));
			Customer cus = (Customer) session.get("customer");
			String phoneNumber = cus.getPhoneNumber();
			System.out.println("phoneNumber--" + phoneNumber );
			
			//1、先根据该用户电话号码得到，password对象
			
			Password passwd = passwordService.getPasswordByPhone (phoneNumber);			
			
			System.out.println("输出Password id--" + passwd.getId());
			//2、根据该password对象，得到roomId
			Room room = passwd.getRoom();
			System.out.println(room.getId());
			
//			懒加载：System.out.println("获取hotel--"  + room.getRoomtype().getHotel().getName());
			
			//3、根据roomId 获取房间类型
			//RoomType roomtype = roomService.getRoomTypeByRoomId();
			
			
			return "toRoomManage";
		}
	
}
