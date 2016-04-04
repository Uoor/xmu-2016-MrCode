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
     private String password;
     private Integer isValid;
     private Timestamp estimatedTime;
     private Timestamp endTime;
     private Contactors contactors;
     
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
    public Password(Integer id, Room room, Mrcodeorder mrcodeorder, Timestamp beginTime, Contactors contactors, String password, Integer isValid, Timestamp estimatedTime, Timestamp endTime) {
        this.id = id;
        this.room = room;
        this.mrcodeorder = mrcodeorder;
        this.beginTime = beginTime;
        this.contactors = contactors;
        this.password = password;
        this.isValid = isValid;
        this.estimatedTime = estimatedTime;
        this.endTime = endTime;
    }

   
    // Property accessors

    public Contactors getContactors() {
		return contactors;
	}

	public void setContactors(Contactors contactors) {
		this.contactors = contactors;
	}

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