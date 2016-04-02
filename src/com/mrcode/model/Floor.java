package com.mrcode.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Floor entity. @author MyEclipse Persistence Tools
 */

public class Floor  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Hotel hotel;
     private Integer floorNumber;
     private String planUrl;
     private Integer measure;
     private Integer roomNumber;
     private Integer alreadyIn;
     private String column1;
     private String column2;
     private Integer column3;
     private Integer column4;
     private Set<Room> rooms = new HashSet<Room>();


    // Constructors

    /** default constructor */
    public Floor() {
    }

	/** minimal constructor */
    public Floor(Integer id, Hotel hotel, Integer floorNumber, String planUrl) {
        this.id = id;
        this.hotel = hotel;
        this.floorNumber = floorNumber;
        this.planUrl = planUrl;
    }
    
    /** full constructor */
    public Floor(Integer id, Hotel hotel, Integer floorNumber, String planUrl, Integer measure, Integer roomNumber, Integer alreadyIn, String column1, String column2, Integer column3, Integer column4, Set rooms) {
        this.id = id;
        this.hotel = hotel;
        this.floorNumber = floorNumber;
        this.planUrl = planUrl;
        this.measure = measure;
        this.roomNumber = roomNumber;
        this.alreadyIn = alreadyIn;
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.column4 = column4;
        this.rooms = rooms;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return this.hotel;
    }
    
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Integer getFloorNumber() {
        return this.floorNumber;
    }
    
    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getPlanUrl() {
        return this.planUrl;
    }
    
    public void setPlanUrl(String planUrl) {
        this.planUrl = planUrl;
    }

    public Integer getMeasure() {
        return this.measure;
    }
    
    public void setMeasure(Integer measure) {
        this.measure = measure;
    }

    public Integer getRoomNumber() {
        return this.roomNumber;
    }
    
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getAlreadyIn() {
        return this.alreadyIn;
    }
    
    public void setAlreadyIn(Integer alreadyIn) {
        this.alreadyIn = alreadyIn;
    }

    public String getColumn1() {
        return this.column1;
    }
    
    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return this.column2;
    }
    
    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public Integer getColumn3() {
        return this.column3;
    }
    
    public void setColumn3(Integer column3) {
        this.column3 = column3;
    }

    public Integer getColumn4() {
        return this.column4;
    }
    
    public void setColumn4(Integer column4) {
        this.column4 = column4;
    }

    public Set getRooms() {
        return this.rooms;
    }
    
    public void setRooms(Set rooms) {
        this.rooms = rooms;
    }

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		try {
			Floor f = (Floor)obj;
			if(f.getId()==this.getId()){
				return true;
			}else return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public int hashCode() {
		return id;
	}
   
    







}