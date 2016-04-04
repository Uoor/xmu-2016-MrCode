package com.mrcode.base;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.mrcode.utils.Const;
import com.mrcode.utils.DataUtils;
import com.mrcode.utils.PageBean;

/**
 * 
 * @author 羽中
 * 
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	private BaseDao<T> baseDao;
	private Class<T> clazz;
	protected Logger log;

	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
		log = Logger.getLogger(clazz);
	}

	@Transactional
	public Integer save(T model) {
		return baseDao.save(model);
	}

	@Transactional
	public void update(T model) {
		baseDao.update(model);

	}

	@Transactional
	public void saveOrUpdate(T model) {
		baseDao.saveOrUpdate(model);

	}

	@Transactional
	public void saveOrUpdateAll(Collection<T> models){
		baseDao.saveOrUpdateAll(models);
	}
	
	@Transactional
	public T getById(Integer id) {
		return baseDao.getById(id);
	}

	@Transactional
	public List<T> getByIds(Integer[] ids) {
		return baseDao.getByIds(ids);
	}

	@Transactional
	public void remove(Integer id) {
		baseDao.remove(id);
	}

	@Transactional
	public boolean delete(Integer id) {
		return baseDao.delete(id);
	}

	/***************************** 查询数据集合 **********************************/

	@Transactional
	public List<T> findByHql(String hql) {
		return this.findByHql(hql, null, null);
	}

	@Transactional
	public List<T> findByHql(String hql, Object[] params, PageBean pageBean,
			String order) {
		return baseDao.findByHql(hql, params, pageBean, order);
	}

	@Transactional
	public int getCount(String sql, Object[] params) {
		return baseDao.getCount(sql, params);
	}

	@Transactional
	public List<T> findByHql(String hql, Map<String, Object> map) {
		return this.findByHql(hql, map, null);
	}

	@Transactional
	public List<T> findByHql(String hql, Map<String, Object> map,
			PageBean pageBean) {
		return this.findByHql(hql, map, pageBean, null);
	}

	@Transactional
	public List<T> findByHql(String hql, Map<String, Object> map,
			PageBean pageBean, String order) {
		return baseDao.findByHql(hql, map, pageBean, order);
	}

	@Transactional
	// 获取实体对象的list集合
	public List<T> getList(PageBean pageBean, Map<String, Object> map) {
		return getList(pageBean, map, null);
	}

	@Transactional
	// 获取排序的实体对象的list集合
	public List<T> getList(PageBean pageBean, Map<String, Object> map,
			String order) {
		String conditions = DataUtils.getHql(map);
		// System.out.println("map.size->"+map.size());
		if (pageBean != null && pageBean.getPageNum() == 0) {
			// System.out.println("dataSize->"+baseDao.getCount(conditions,
			// map));
			pageBean.setDataSize(baseDao.getCount(conditions, map));
		}
		return baseDao.findByHql("from " + clazz.getSimpleName() + conditions,
				map, pageBean, order);
	}

	@Transactional
	public List<T> findBySql(String sql, Map<String, Object> map,
			PageBean pageBean, String order) {
		return baseDao.findBySql(sql, map, pageBean, order);
	}
	
	@Transactional    
	public List<T> findBySql(String sql, Object[] params,
			PageBean pageBean, String order) {
		return baseDao.findBySql(sql, params, pageBean, order);
	}
	
	@Transactional
	public List<Object[]> findObjectsBySql(String sql, Map<String, Object> map) {
		return baseDao.findObjectsBySql(sql, map);
	}

	@Transactional
	public T findUniqueByHql(String hql, Map<String, Object> map) {
		return baseDao.findUniqueByHql(hql, map);
	}

	@Transactional
	public int getCount(Map<String, Object> map) {
		return baseDao.getCount(map);
	}

	@Transactional
	public int getCount(String conditions, Map<String, Object> map) {
		return baseDao.getCount(conditions, map);
	}

	@Transactional
	public int getCountBySql(String sql, Map<String, Object> map) {
		return baseDao.getCountBySql(sql, map);
	}

	@Transactional
	public int getCountBySql(String sql, Object[] params) {
		return baseDao.getCountBySql(sql, params);
	}
	
	@Transactional
	public int executeByHql(String hql, Map<String, Object> map) {
		return baseDao.executeByHql(hql, map);
	}

	@Transactional
	public int executeBySql(String sql, Map<String, Object> map) {
		return baseDao.executeBySql(sql, map);
	}

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	// 返回json格式的数�?
	@Transactional
	public String getJsonList(PageBean pageBean, Map<String, Object> map,
			String order, HttpServletRequest request,
			Map<String, Object> otherParams) {
		return getJsonList(pageBean, map, order, request, otherParams, null);
	}

	@Transactional
	public String getJsonList(PageBean pageBean, Map<String, Object> map,
			String order) {
		return getJsonList(pageBean, map, order, null);
	}

	@Transactional
	public String getJsonList(PageBean pageBean, Map<String, Object> map,
			String order, HttpServletRequest requset) {
		return getJsonList(pageBean, map, order, requset, null);
	}

	@Transactional
	public String getJsonList(PageBean pageBean, Map<String, Object> map,
			String order, HttpServletRequest request,
			Map<String, Object> otherParams, String[] excludes) {
		if (order == null && request != null) {
			order = " ";
			order += StringUtils.isEmpty(request.getParameter("sortname")) ? " id"
					: " " + request.getParameter("sortname");
			order += StringUtils.isEmpty(request.getParameter("sortorder")) ? " desc"
					: " " + request.getParameter("sortorder");
		}
		List<T> list = new ArrayList<T>();
		list = getList(pageBean, map, order);
		HashMap<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put(Const.Page, pageBean);
		tempMap.put(Const.Rows, list);
		tempMap.put("Total", pageBean.getDataSize());
		if (otherParams != null) {
			Iterator<Entry<String, Object>> iter = otherParams.entrySet()
					.iterator();
			while (iter.hasNext()) {
				Entry<String, Object> entry = iter.next();
				tempMap.put(entry.getKey(), entry.getValue());
			}
		}
		JsonConfig config = new JsonConfig();
		if (excludes == null) {
			excludes = new String[] {}; // 待添�?
		}
		config.setExcludes(excludes);// 出去dept属�?
		JSONObject json = JSONObject.fromObject(tempMap, config);
		return json.toString();
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
}