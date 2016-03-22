package com.mrcode.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Hotel entity. @author MyEclipse Persistence Tools
 */

public class Hotel  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String userName;
     private String passWord;
     private String name;
     private String picUrl;
     private Float longitude;
     private Float latitude;
     private String addressRemark;
     private String remark;
     private Integer column3;
     private Integer column4;
     private Set floors = new HashSet(0);


    // Constructors

    /** default constructor */
    public Hotel() {
    }

	/** minimal constructor */
    public Hotel(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Hotel(Integer id, String userName, String passWord, String name, String picUrl, Float longitude, Float latitude, String addressRemark, String remark, Integer column3, Integer column4, Set floors) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.name = name;
        this.picUrl = picUrl;
        this.longitude = longitude;
        this.latitude = latitude;
        this.addressRemark = addressRemark;
        this.remark = remark;
        this.column3 = column3;
        this.column4 = column4;
        this.floors = floors;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return this.passWord;
    }
    
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return this.picUrl;
    }
    
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Float getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public String getAddressRemark() {
        return this.addressRemark;
    }
    
    public void setAddressRemark(String addressRemark) {
        this.addressRemark = addressRemark;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
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

    public Set getFloors() {
        return this.floors;
    }
    
    public void setFloors(Set floors) {
        this.floors = floors;
    }
   








}