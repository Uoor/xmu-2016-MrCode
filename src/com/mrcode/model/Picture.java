package com.mrcode.model;



/**
 * Picture entity. @author MyEclipse Persistence Tools
 */

public class Picture  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Roomtype roomtype;
     private String url;


    // Constructors

    /** default constructor */
    public Picture() {
    }

	/** minimal constructor */
    public Picture(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Picture(Integer id, Roomtype roomtype, String url) {
        this.id = id;
        this.roomtype = roomtype;
        this.url = url;
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

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
   








}