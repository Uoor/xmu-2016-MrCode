package com.mrcode.model;

import java.sql.Timestamp;


/**
 * Password entity. @author MyEclipse Persistence Tools
 */

public class Password  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Room room;
     private Mrcodeorder mrcodeorder;
     private Timestamp beginTime;
     private Integer roomId;
     private String password;
     private Integer isValid;
     private Timestamp estimatedTime;
     private Timestamp endTime;


    // Constructors

    /** default constructor */
    public Password() {
    }

	/** minimal constructor */
    public Password(Integer id, Room room) {
        this.id = id;
        this.room = room;
    }
    
    /** full constructor */
    public Password(Integer id, Room room, Mrcodeorder mrcodeorder, Timestamp beginTime, Integer roomId, String password, Integer isValid, Timestamp estimatedTime, Timestamp endTime) {
        this.id = id;
        this.room = room;
        this.mrcodeorder = mrcodeorder;
        this.beginTime = beginTime;
        this.roomId = roomId;
        this.password = password;
        this.isValid = isValid;
        this.estimatedTime = estimatedTime;
        this.endTime = endTime;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Room getRoom() {
        return this.room;
    }
    
    public void setRoom(Room room) {
        this.room = room;
    }

    public Mrcodeorder getMrcodeorder() {
        return this.mrcodeorder;
    }
    
    public void setMrcodeorder(Mrcodeorder mrcodeorder) {
        this.mrcodeorder = mrcodeorder;
    }

    public Timestamp getBeginTime() {
        return this.beginTime;
    }
    
    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getRoomId() {
        return this.roomId;
    }
    
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsValid() {
        return this.isValid;
    }
    
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Timestamp getEstimatedTime() {
        return this.estimatedTime;
    }
    
    public void setEstimatedTime(Timestamp estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Timestamp getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
   








}