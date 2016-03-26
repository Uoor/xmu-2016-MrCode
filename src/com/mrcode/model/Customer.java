package com.mrcode.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String userName;
     private String password;
     private String phoneNumber;
     private String trueName;
	 private String identityCard;
     private String email;
     private Timestamp birthday;
     private String gender;
     private String nation;
     private String identityPic;
     private Integer perfectInformation;
     private Integer brandPic;
     private Integer temporary;
     private String certificateType;
     private Timestamp createTime;
     private String address;
     private String accountNum;
     private Float balance;
     private Float credit;
     private Integer shopLevel;
     private Integer cusType;
     private Set contactorses = new HashSet(0);
     private Set grouppurchasevouchers = new HashSet(0);
     private Set mrcodeorders = new HashSet(0);


    // Constructors

    /** default constructor */
    public Customer() {
    }

	/** minimal constructor */
    public Customer(Integer id, String userName, String password, String phoneNumber) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    
    /** full constructor */
    public Customer(Integer id, String userName, String password, String phoneNumber, String trueName, String identityCard, Timestamp birthday, String gender, String nation, String identityPic, Integer perfectInformation, Integer brandPic, Integer temporary, String certificateType, Timestamp createTime, String address, String accountNum, Float balance, Float credit, Integer column3, Integer column4, Set contactorses, Set grouppurchasevouchers, Set mrcodeorders) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.trueName = trueName;
        this.identityCard = identityCard;
        this.birthday = birthday;
        this.gender = gender;
        this.nation = nation;
        this.identityPic = identityPic;
        this.perfectInformation = perfectInformation;
        this.brandPic = brandPic;
        this.temporary = temporary;
        this.certificateType = certificateType;
        this.createTime = createTime;
        this.address = address;
        this.accountNum = accountNum;
        this.balance = balance;
        this.credit = credit;
        this.shopLevel = shopLevel;
        this.cusType = cusType;
        this.contactorses = contactorses;
        this.grouppurchasevouchers = grouppurchasevouchers;
        this.mrcodeorders = mrcodeorders;
    }

   
    // Property accessors
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
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

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTrueName() {
        return this.trueName;
    }
    
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getIdentityCard() {
        return this.identityCard;
    }
    
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Timestamp getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return this.nation;
    }
    
    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdentityPic() {
        return this.identityPic;
    }
    
    public void setIdentityPic(String identityPic) {
        this.identityPic = identityPic;
    }

    public Integer getPerfectInformation() {
        return this.perfectInformation;
    }
    
    public void setPerfectInformation(Integer perfectInformation) {
        this.perfectInformation = perfectInformation;
    }

    public Integer getBrandPic() {
        return this.brandPic;
    }
    
    public void setBrandPic(Integer brandPic) {
        this.brandPic = brandPic;
    }

    public Integer getTemporary() {
        return this.temporary;
    }
    
    public void setTemporary(Integer temporary) {
        this.temporary = temporary;
    }

    public String getCertificateType() {
        return this.certificateType;
    }
    
    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountNum() {
        return this.accountNum;
    }
    
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public Float getBalance() {
        return this.balance;
    }
    
    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getCredit() {
        return this.credit;
    }
    
    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Integer getShopLevel() {
        return this.shopLevel;
    }
    

    public Set getContactorses() {
        return this.contactorses;
    }
    
    public void setContactorses(Set contactorses) {
        this.contactorses = contactorses;
    }

    public Set getGrouppurchasevouchers() {
        return this.grouppurchasevouchers;
    }
    
    public void setGrouppurchasevouchers(Set grouppurchasevouchers) {
        this.grouppurchasevouchers = grouppurchasevouchers;
    }

    public Set getMrcodeorders() {
        return this.mrcodeorders;
    }
    
    public void setMrcodeorders(Set mrcodeorders) {
        this.mrcodeorders = mrcodeorders;
    }

	public Integer getCusType() {
		return cusType;
	}

	public void setCusType(Integer cusType) {
		this.cusType = cusType;
	}

	public void setShopLevel(Integer shopLevel) {
		this.shopLevel = shopLevel;
	}
   








}