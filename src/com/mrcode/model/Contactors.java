package com.mrcode.model;

import java.util.HashSet;
import java.util.Set;




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
     private Integer isSelf;
     /**
 	 * 码团订单表 ，表示本类与Mrcodeorder的多对多关系  
 	 */
 	private Set<Mrcodeorder> orders = new HashSet<Mrcodeorder>();

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

    public Integer getIsSelf() {
		return isSelf;
	}

	public void setIsSelf(Integer isSelf) {
		this.isSelf = isSelf;
	}

	public Integer getId() {
        return this.id;
    }
    
    public Set<Mrcodeorder> getOrders() {
		return orders;
	}

	public void setOrders(Set<Mrcodeorder> orders) {
		this.orders = orders;
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