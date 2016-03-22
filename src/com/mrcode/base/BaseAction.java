package com.mrcode.base;

import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.mrcode.utils.JsonValueFormat;
import com.mrcode.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 
 * @author 羽中
 * 
 * @param <T>
 */
public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T>, Preparable, SessionAware, ServletRequestAware,
		ServletResponseAware {

	private static final long serialVersionUID = 1L;
	protected T model;
	protected List<T> models = new ArrayList<T>();

	protected Map<String, Object> session;
	protected HttpServletResponse response;
	protected HttpServletRequest request;

	protected Logger log;
	protected Class<?> clazz;
	/*******************************************************************/
	protected int defaultSize = 10; // 每页默认大小
	/* protected int currentPage = 1; // 当前�?*/
	/*******************************************************************/
	// action查询条件
	protected Map<String, Object> paramMap = new HashMap<String, Object>();
	protected PageBean pageBean = new PageBean(defaultSize);

	// 封装json参数
	protected Map<String, Object> dataMap = new HashMap<String, Object>();
	/*******************************************************************/
	protected final static String TYPE_REDIRECT = "redirect";
	protected final static String TYPE_CHAIN = "chain";
	protected final static String TYPE_REDIRECT_ACTION = "redirectAction";

	/*******************************************************************/
	@SuppressWarnings("unchecked")
	public BaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			clazz = (Class<?>) type.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
			log = Logger.getLogger(clazz);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public void prepare() {
	};

	/******************************* 重写getParameter方法 begin ************************************/
	/**
	 * 
	 * @param arg
	 *            变量�?
	 * @param defaultValue
	 *            默认�?
	 * @return String�?
	 */
	public String getParameter(String arg, String defaultValue) {
		String temp = request.getParameter(arg);
		if (StringUtils.isEmpty(temp)) {
			return defaultValue;
		} else {
			return temp.trim();
		}
	}

	/**
	 * 
	 * @param arg
	 *            变量�?
	 * @return String�?
	 */
	public String getParameter(String arg) {
		return getParameter(arg, "");
	}

	/**
	 * 
	 * @param arg
	 *            变量�?
	 * @param defaultValue
	 *            默认�?
	 * @return
	 */
	public int getIntParameter(String arg, int defaultValue) {
		String temp = request.getParameter(arg);
		if (temp == null) {
			return defaultValue;
		} else {
			temp = temp.trim();
			try {
				return Integer.parseInt(temp);
			} catch (Exception e) {
				log.error(e.getMessage());
				return defaultValue;
			}
		}
	}

	/******************************* 重写getParameter方法 end ************************************/
	/******************************* 向前台返回json格式数据 begin ************************************/
	public void writeStringToResponse(String content) {
		try {
			// 设置字符�?
			response.setCharacterEncoding("utf-8");
			// 获取向前台的打印�?
			PrintWriter pw = response.getWriter();
			pw.write(content);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeJsonToResponse(List<?> list) {
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "addTime"/*, "childAreas","suppliers"*/}); // 除去addTime属�?
		JSONArray json = JSONArray.fromObject(list, config); 
		writeStringToResponse(json.toString());
	}

	public void writeJsonToResponse(Object o, Map<String, Object> otherParams) {
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "addTime" });// 除去dept属�?
		HashMap<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("Model", o);
		if (otherParams != null) {
			Iterator<Entry<String, Object>> iter = otherParams.entrySet()
					.iterator();
			while (iter.hasNext()) {
				Entry<String, Object> entry = iter.next();
				tempMap.put(entry.getKey(), entry.getValue());
			}
		}
		JSONObject json = JSONObject.fromObject(tempMap, config);
		writeStringToResponse(json.toString());
	}

	/**
	 * 把Object转抱成Json时更改数据的默认转换格式
	 * @param o 
	 * @param otherParams 其它参数
	 * @param excludes 不进行序列化属�?的名�?
	 */
	public void writeJsonToResponseWithDataFormat(Object o, Map<String, Object> otherParams, String excludes[]) {
		JsonConfig config = new JsonConfig();
		//更改Date类型转成json数据的格式化形式
		config.registerJsonValueProcessor(Date.class, new JsonValueFormat());
		config.setExcludes(excludes);// 除去dept属�?
		HashMap<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("Model", o);
		if (otherParams != null) {
			Iterator<Entry<String, Object>> iter = otherParams.entrySet()
					.iterator();
			while (iter.hasNext()) {
				Entry<String, Object> entry = iter.next();
				tempMap.put(entry.getKey(), entry.getValue());
			}
		}
		JSONObject json = JSONObject.fromObject(tempMap, config);
		writeStringToResponse(json.toString().replaceAll("null", "[]"));
		
	}
	
	/******************************* 向前台返回json格式数据 end ************************************/
	// ---------------getter and setter begin--------------------
	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public List<T> getModels() {
		return models;
	}

	public void setModels(List<T> models) {
		this.models = models;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	// ---------------getter and setter end--------------------

}
