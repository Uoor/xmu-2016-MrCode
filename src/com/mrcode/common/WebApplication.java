package com.mrcode.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.mrcode.utils.Aes;
import com.mrcode.utils.EscapeUnescape;

public class WebApplication {
	
	public static String getIP(){
		String ip = null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ip; 
	}
	// ---------------get user message begin--------------------

	// ---------------get user message end--------------------
	/**
	 * 得到session
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 得到request
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println("request=>"+request);
		return request;
	}
	
	/**
	 * 得到response
	 * 
	 * @return
	 */
	public static HttpServletResponse getResponse() {
		HttpServletResponse response = ServletActionContext.getResponse();
		return response;
	}
	
	/**
	 * 获得工程的上下文路径
	 * @return
	 */
	public static String getContextPath(){
		return getSession().getServletContext().getRealPath("");
	}
	
	/**
	 * 获得资源文件的路径
	 * @return
	 */
	public static String getResourcePath(){
		return getContextPath()+"/resource";
	}
	/**
	 * 获得资源测试文件路径
	 * @return
	 */
	public static String getDemoResourcePath(){
		return getContextPath()+"/resource/demo-image";
	}
	
	/**
	 * 添加cookie
	 * @param key
	 * @param value
	 * @param jiami 是否采用aes加密
	 */
	public static void addCookie(String key,String value,boolean jiami){
		if(jiami){
			//采用aes加密
			value = Aes.encrypt(EscapeUnescape.escape(value));
		}
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(60*60*24*7);	//默认保存7天
		getResponse().addCookie(cookie);
	}
	/**
	 * 默认采用加密来添加cookie
	 * @param key
	 * @param value
	 */
	public static void addCookie(String key,String value){
		addCookie(key, value,true);
	}
	/**
	 * 
	 * @param key
	 * @param jiami
	 * @return
	 */
	public static String getCookie(String key,boolean jiami){ 
		System.out.println("WebApplication.getCookie()");
		Cookie[] allCookies = getRequest().getCookies();
		if(allCookies!=null && allCookies.length!=0){
			for (int i = 0; i < allCookies.length; i++) {
				Cookie cookie = allCookies[i];
				if(key.equals(cookie.getName())){
					String value = EscapeUnescape.unescape(cookie.getValue());
					System.out.println("key=>"+cookie.getName()+","+"value=>"+value);
					if(value==null){ 
						value = "";
					}else if(jiami){
						value = Aes.desEncrypt(EscapeUnescape.unescape(cookie.getValue()));
					}
					return value;
				}
			}
		}
		return "";
	}
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getCookie(String key){
		return getCookie(key,true);
	}
	/**
	 * 删除cookie
	 * @param key
	 */
	public static void removeCookie(String key){
		Cookie[] allCookies = getRequest().getCookies();
		if(allCookies!=null&&allCookies.length!=0){
			for (int i = 0; i < allCookies.length; i++) {
				Cookie cookie = allCookies[i];
				if(key.equals(cookie.getName())){
					Cookie nullCookie = new Cookie(key, null);
					nullCookie.setMaxAge(0);
					getResponse().addCookie(nullCookie);
				}
			}
		}
	}
	
	
}
