package com.mrcode.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Room entity. @author MyEclipse Persistence Tools
 */

public class Room  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Roomtype roomtype;
     private Floor floor;
     private String roomNumber;
     private Integer state;
     private String column1;
     private String column2;
     private Integer column3;
     private Set roomdates = new HashSet(0);
     private Password password;


    // Constructors

    /** default constructor */
    public Room() {
    }

	/** minimal constructor */
    public Room(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Room(Integer id, Roomtype roomtype, Floor floor, String roomNumber, Integer state, String column1, String column2, Integer column3, Set roomdates, Password password) {
        this.id = id;
        this.roomtype = roomtype;
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.state = state;
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.roomdates = roomdates;
        this.password = password;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Roomtype getRoomtype() {
        return this.roomtype;
    }
    
    public void setRoomtype(Roomtype roomtype) {
        this.roomtype = roomtype;
    }

    public Floor getFloor() {
        return this.floor;
    }
    
    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }
    
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getState() {
        return this.state;
    }
    
    public void setState(Integer state) {
        this.state = state;
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

    public Set getRoomdates() {
        return this.roomdates;
    }
    
    public void setRoomdates(Set roomdates) {
        this.roomdates = roomdates;
    }

    public Password getPassword() {
        return this.password;
    }
    
    public void setPassword(Password password) {
        this.password = password;
    }
   








}