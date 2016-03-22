package com.mrcode.base;


import java.io.Serializable;

import com.sun.org.apache.commons.collections.comparators.ComparableComparator;

/**
 * 基础pojo类
 * @author 羽中
 *
 */
public class BaseModel implements Comparable, Serializable {

	/**
	 * 
	 */
	
	protected Integer id;
	public BaseModel() {
		super();
		this.delFlag = 1;
	}
	protected Short delFlag;	//删除状态（0：已删除，1：未删除）
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Short getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Short delFlag) {
		this.delFlag = delFlag;
	}
	public int compareTo(Object o) {
		BaseModel other = (BaseModel)o;
		if(this.id > other.getId()){
			return 1;
		}else if(this.id < other.getId()){
			return -1;
		}else{
			return 0;
		}
	}
	
}
