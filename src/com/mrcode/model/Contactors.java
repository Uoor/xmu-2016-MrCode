package com.mrcode.model;



/**
 * Contactors entity. @author MyEclipse Persistence Tools
 */

public class Contactors  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Customer customer;
     private String identityCard;
     private String phoneNumber;
     private String name;


    // Constructors

    /** default constructor */
    public Contactors() {
    }

	/** minimal constructor */
    public Contactors(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Contactors(Integer id, Customer customer, String identityCard, String phoneNumber, String name) {
        this.id = id;
        this.customer = customer;
        this.identityCard = identityCard;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getIdentityCard() {
        return this.identityCard;
    }
    
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   








}