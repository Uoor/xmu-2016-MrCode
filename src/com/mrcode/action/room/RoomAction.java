package com.mrcode.action.room;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.model.Customer;
import com.mrcode.model.Floor;
import com.mrcode.model.Grouppurchasevoucher;
import com.mrcode.model.Hotel;
import com.mrcode.model.Room;
import com.mrcode.model.Roomtype;
import com.mrcode.service.FloorService;
import com.mrcode.service.GrouppurchasevoucherService;
import com.mrcode.service.HotelService;
import com.mrcode.service.RoomService;
import com.mrcode.service.RoomtypeService;
import com.mrcode.utils.Const;

@Controller
@ParentPackage("customers")
@Namespace("/room")
public class RoomAction extends BaseAction<Room>{

	@Autowired
	GrouppurchasevoucherService grouppurchasevoucherService;
	@Autowired
	FloorService floorService;
	@Autowired
	RoomtypeService roomtypeService;
	@Autowired
	RoomService roomService;
	@Autowired
	HotelService hotelService;
	
	@Action(value="updateRoomInfo")
	public void updateRoomInfo() throws Exception{
		String roomJson=(String) request.getParameter("json").trim();
		
		JSONObject jsonObject = JSONObject.fromObject(roomJson);
		String roomNumber = jsonObject.getString("rmId");
		String floorid = jsonObject.getString("rmFloor");
		String roomType = jsonObject.getString("rmCatalog");
		Integer f=Integer.parseInt(floorid);
		Floor floor = floorService.findFloorByHotelAndFloornum(1, f);
		Roomtype roomtype = roomtypeService.findRoomtypeByTypeId(1, roomType);
		List<Room> roomlist = roomService.getByRoomNumAndType(roomNumber, roomtype);
		if(roomlist.size()==0){
			response.getWriter().write("{success:true}");
			return;
		}
		Room room = roomlist.get(0);
		System.out.println();
		if(room==null){
		    room = new Room();
			room.setFloor(floor);
			room.setRoomtype(roomtype);
			room.setRoomNumber(roomNumber);
			room.setState(0);
			roomService.save(room);
		}
		else{
			room.setFloor(floor);
			room.setRoomtype(roomtype);
			room.setRoomNumber(roomNumber);
			room.setState(0);
			roomService.update(room);
		}
		response.getWriter().write("{success:true}");
		return;
	}
	
	
	@Action(value="updateFloorInfo")
	public void updateFloorInfo() throws Exception{
		
		
		
		
		return;
	}
	
	@Action(value="updateRoomTypeInfo")
	public void updateRoomTypeInfo() throws Exception{
	String roomJson=(String) request.getParameter("json").trim();
		
		JSONObject jsonObject = JSONObject.fromObject(roomJson);
		String typeId = jsonObject.getString("rcName");
		String typeName = jsonObject.getString("rcBedNumber");
		String priceString = jsonObject.getString("rcPrePrice");
		String discountString = jsonObject.getString("rcPreDiscount");
		
		priceString=priceString.trim();
		discountString=discountString.trim();
		
		Float price=Float.parseFloat(priceString);
		Float discount=Float.parseFloat(discountString);
		
		Roomtype roomtype = roomtypeService.findRoomtypeByTypeId(1, typeId);
		Hotel hotel = hotelService.getById(1);
		System.out.println();
		if(roomtype==null){
			roomtype = new Roomtype();
			roomtype.setTypeName(typeName);
			roomtype.setTypeId(typeId);
			roomtype.setPrice(price);
			roomtype.setDiscount(discount);
			roomtype.setHotel(hotel);
			roomtypeService.save(roomtype);
		}
		else{
			roomtype.setTypeName(typeName);
			roomtype.setTypeId(typeId);
			roomtype.setPrice(price);
			roomtype.setDiscount(discount);
			roomtype.setHotel(hotel);
			roomtypeService.update(roomtype);
		}
		response.getWriter().write("{success:true}");
		return;
	}
	
}
