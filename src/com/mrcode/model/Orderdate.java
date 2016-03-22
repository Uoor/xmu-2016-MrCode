package com.mrcode.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Orderdate entity. @author MyEclipse Persistence Tools
 */

public class Orderdate  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Timestamp date;
     private Integer orderNumber;
     private String column1;
     private Integer column2;
     private Set roomdates = new HashSet(0);


    // Constructors

    /** default constructor */
    public Orderdate() {
    }

	/** minimal constructor */
    public Orderdate(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Orderdate(Integer id, Timestamp date, Integer orderNumber, String column1, Integer column2, Set roomdates) {
        this.id = id;
        this.date = date;
        this.orderNumber = orderNumber;
        this.column1 = column1;
        this.column2 = column2;
        this.roomdates = roomdates;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return this.date;
    }
    
    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getOrderNumber() {
        return this.orderNumber;
    }
    
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getColumn1() {
        return this.column1;
    }
    
    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public Integer getColumn2() {
        return this.column2;
    }
    
    public void setColumn2(Integer column2) {
        this.column2 = column2;
    }

    public Set getRoomdates() {
        return this.roomdates;
    }
    
    public void setRoomdates(Set roomdates) {
        this.roomdates = roomdates;
    }
   








}