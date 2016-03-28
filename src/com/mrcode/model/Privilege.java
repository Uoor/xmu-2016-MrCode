package com.mrcode.model;

import java.util.Arrays;

/**
 * 赔率实体类
 * @author Saber
 *
 */
public class Privilege {
	private Integer id;
	private String url;
	private String name; // 权限名称
	
	
	public Privilege( Integer id, String url, String name) {
		this.name = name;
		this.url = url;
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
