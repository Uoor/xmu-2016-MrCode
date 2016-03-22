package com.mrcode.model;

import java.sql.Timestamp;


/**
 * Grouppurchasevoucher entity. @author MyEclipse Persistence Tools
 */

public class Grouppurchasevoucher  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Roomtype roomtype;
     private Mrcodeorder mrcodeorder;
     private Customer customer;
     private String orderCode;
     private Integer hotelId;
     private Integer userd;
     private Timestamp consumeTime;
     private Float price;
     private Timestamp createTime;
     private String column2;
     private Integer column3;


    // Constructors

    /** default constructor */
    public Grouppurchasevoucher() {
    }

	/** minimal constructor */
    public Grouppurchasevoucher(Integer id, Roomtype roomtype, Mrcodeorder mrcodeorder, Customer customer, String orderCode, Integer hotelId) {
        this.id = id;
        this.roomtype = roomtype;
        this.mrcodeorder = mrcodeorder;
        this.customer = customer;
        this.orderCode = orderCode;
        this.hotelId = hotelId;
    }
    
    /** full constructor */
    public Grouppurchasevoucher(Integer id, Roomtype roomtype, Mrcodeorder mrcodeorder, Customer customer, String orderCode, Integer hotelId, Integer userd, Timestamp consumeTime, Float price, Timestamp createTime, String column2, Integer column3) {
        this.id = id;
        this.roomtype = roomtype;
        this.mrcodeorder = mrcodeorder;
        this.customer = customer;
        this.orderCode = orderCode;
        this.hotelId = hotelId;
        this.userd = userd;
        this.consumeTime = consumeTime;
        this.price = price;
        this.createTime = createTime;
        this.column2 = column2;
        this.column3 = column3;
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

    public Mrcodeorder getMrcodeorder() {
        return this.mrcodeorder;
    }
    
    public void setMrcodeorder(Mrcodeorder mrcodeorder) {
        this.mrcodeorder = mrcodeorder;
    }

    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderCode() {
        return this.orderCode;
    }
    
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getHotelId() {
        return this.hotelId;
    }
    
    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getUserd() {
        return this.userd;
    }
    
    public void setUserd(Integer userd) {
        this.userd = userd;
    }

    public Timestamp getConsumeTime() {
        return this.consumeTime;
    }
    
    public void setConsumeTime(Timestamp consumeTime) {
        this.consumeTime = consumeTime;
    }

    public Float getPrice() {
        return this.price;
    }
    
    public void setPrice(Float price) {
        this.price = price;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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
   








}