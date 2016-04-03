package com.mrcode.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Mrcodeorder entity. @author MyEclipse Persistence Tools
 */

public class Mrcodeorder  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Customer customer;
     private String orderCode;
     private Integer depositAlready;
     private Float depositPrice;
     private Integer hasPay;
     private String voucherNumber;
     private Integer hasComfirm;
     private Timestamp createTime;
     private Timestamp endTime;
     private Float refund;
     private Integer isRefund;
     private String column1;
     private String column2;
     private String column3;
     private Integer column4;
     private Integer column5;
     private Set passwords = new HashSet(0);
     private Grouppurchasevoucher grouppurchasevoucher;
     /**
  	 * 联系人表 ，表示本类与Contactors的多对多关系  
  	 */
  	private Set<Contactors> contactors = new HashSet<Contactors>();

    // Constructors

    /** default constructor */
    public Mrcodeorder() {
    }

	/** minimal constructor */
    public Mrcodeorder(Integer id, String orderCode) {
        this.id = id;
        this.orderCode = orderCode;
    }
    
    /** full constructor */
    public Mrcodeorder(Integer id, Customer customer, String orderCode, Integer depositAlready, Float depositPrice, Integer hasPay, String voucherNumber, Integer hasComfirm, Timestamp createTime, Timestamp endTime, Float refund, Integer isRefund, String column1, String column2, String column3, Integer column4, Integer column5, Set passwords, Grouppurchasevoucher grouppurchasevoucher) {
        this.id = id;
        this.customer = customer;
        this.orderCode = orderCode;
        this.depositAlready = depositAlready;
        this.depositPrice = depositPrice;
        this.hasPay = hasPay;
        this.voucherNumber = voucherNumber;
        this.hasComfirm = hasComfirm;
        this.createTime = createTime;
        this.endTime = endTime;
        this.refund = refund;
        this.isRefund = isRefund;
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.column4 = column4;
        this.column5 = column5;
        this.passwords = passwords;
        this.grouppurchasevoucher = grouppurchasevoucher;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public Set<Contactors> getContactors() {
		return contactors;
	}

	public void setContactors(Set<Contactors> contactors) {
		this.contactors = contactors;
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

    public String getOrderCode() {
        return this.orderCode;
    }
    
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getDepositAlready() {
        return this.depositAlready;
    }
    
    public void setDepositAlready(Integer depositAlready) {
        this.depositAlready = depositAlready;
    }

    public Float getDepositPrice() {
        return this.depositPrice;
    }
    
    public void setDepositPrice(Float depositPrice) {
        this.depositPrice = depositPrice;
    }

    public Integer getHasPay() {
        return this.hasPay;
    }
    
    public void setHasPay(Integer hasPay) {
        this.hasPay = hasPay;
    }

    public String getVoucherNumber() {
        return this.voucherNumber;
    }
    
    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public Integer getHasComfirm() {
        return this.hasComfirm;
    }
    
    public void setHasComfirm(Integer hasComfirm) {
        this.hasComfirm = hasComfirm;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Float getRefund() {
        return this.refund;
    }
    
    public void setRefund(Float refund) {
        this.refund = refund;
    }

    public Integer getIsRefund() {
        return this.isRefund;
    }
    
    public void setIsRefund(Integer isRefund) {
        this.isRefund = isRefund;
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

    public String getColumn3() {
        return this.column3;
    }
    
    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public Integer getColumn4() {
        return this.column4;
    }
    
    public void setColumn4(Integer column4) {
        this.column4 = column4;
    }

    public Integer getColumn5() {
        return this.column5;
    }
    
    public void setColumn5(Integer column5) {
        this.column5 = column5;
    }

    public Set getPasswords() {
        return this.passwords;
    }
    
    public void setPasswords(Set passwords) {
        this.passwords = passwords;
    }

    public Grouppurchasevoucher getGrouppurchasevoucher() {
        return this.grouppurchasevoucher;
    }
    
    public void setGrouppurchasevoucher(Grouppurchasevoucher grouppurchasevoucher) {
        this.grouppurchasevoucher = grouppurchasevoucher;
    }
   








}