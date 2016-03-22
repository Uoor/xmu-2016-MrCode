package com.mrcode.model;



/**
 * Roomdate entity. @author MyEclipse Persistence Tools
 */

public class Roomdate  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Room room;
     private Orderdate orderdate;
     private String column1;
     private Integer column2;


    // Constructors

    /** default constructor */
    public Roomdate() {
    }

	/** minimal constructor */
    public Roomdate(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Roomdate(Integer id, Room room, Orderdate orderdate, String column1, Integer column2) {
        this.id = id;
        this.room = room;
        this.orderdate = orderdate;
        this.column1 = column1;
        this.column2 = column2;
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

    public Orderdate getOrderdate() {
        return this.orderdate;
    }
    
    public void setOrderdate(Orderdate orderdate) {
        this.orderdate = orderdate;
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
   








}