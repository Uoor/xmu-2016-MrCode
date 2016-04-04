package com.mrcode.base;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mrcode.utils.PageBean;

/**
 * 
 * @author 羽中
 * 
 * @param <T>
 */
public interface BaseService<T> {
	/**
	 * 保存实体
	 * 
	 * @param model
	 *            实体
	 */
	public Integer save(T model);

	/**
	 * 修改实体
	 * 
	 * @param model
	 *            实体
	 */
	public void update(T model);

	/**
	 * 当实体存在时修改，不存在时保�?
	 * 
	 * @param model
	 */
	public void saveOrUpdate(T model);

	/**
	 * 当实体存在时修改，不存在时保�?
	 * 
	 * @param model
	 */
	public void saveOrUpdateAll(Collection<T> models);
	
	/**
	 * 通过id获取实体
	 * 
	 * @param id
	 * @return
	 */
	public T getById(Integer id);

	/**
	 * 通过id数组获取实体集合
	 * 
	 * @param ids
	 * @return
	 */
	public List<T> getByIds(Integer[] ids);

	/**
	 * 通过id删除实体 物理删除，直接将数据从数据库中删�?
	 * 
	 * @param id
	 */
	public void remove(Integer id);

	/**
	 * 通过id删除实体 逻辑删除,将实体delflag字段�?
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Integer id);

	/**************** hql语句执行的操�?*******************/
	// 根据hql语句查询出一个集�?
	/**
	 * 
	 * @param hql
	 *            hql语句
	 * @param map
	 *            参数map
	 * @param pageBean
	 *            分页对象
	 * @param order
	 *            顺序
	 * @return
	 */
	public List<T> findByHql(String hql, Map<String, Object> map,
			PageBean pageBean, String order);
	/**
	 * 
	 * @param hql
	 * @param map
	 * @param pageBean
	 * @param order
	 * @return
	 */
	public List<T> findByHql(String hql, Object[] params,
			PageBean pageBean, String order);
	/**
	 * 
	 * @param hql
	 * @return
	 */
	public List<T> findByHql(String hql);

	/**
	 * 
	 * @param hql
	 * @param map
	 * @return
	 */
	public List<T> findByHql(String hql, Map<String, Object> map);
	
	/**
	 * 
	 * @param hql
	 * @param map
	 * @param pageBean
	 * @return
	 */
	public List<T> findByHql(String hql, Map<String, Object> map,
			PageBean pageBean);// 分页查询出一组实�?
	
	/**
	 * 
	 * @param sql
	 * @param map
	 * @param pageBean
	 * @param order
	 * @return
	 */
	public List<T> findBySql(String sql, Map<String, Object> map,
			PageBean pageBean, String order);
	
	/**
	 * 
	 * @param sql
	 * @param params
	 * @param pageBean
	 * @param order
	 * @return
	 */
	public List<T> findBySql(String sql, Object[] params,
			PageBean pageBean, String order);
	/**
	 * 
	 * @param sql
	 * @param map
	 * @return
	 */
	public List<Object[]> findObjectsBySql(String sql, Map<String, Object> map);// 查询实体类中的某些属�?

	/**
	 * 
	 * @param pageBean
	 * @param map
	 * @return
	 */
	public List<T> getList(PageBean pageBean, Map<String, Object> map);

	/**
	 * 
	 * @param pageBean
	 * @param map
	 * @param order
	 * @return
	 */
	public List<T> getList(PageBean pageBean, Map<String, Object> map,
			String order);

	/**
	 * 
	 * @param hql
	 * @param map
	 * @return
	 */
	public T findUniqueByHql(String hql, Map<String, Object> map);

	/**
	 * 
	 * @param map
	 * @return
	 */
	// 查询总的记录�?
	public int getCount(Map<String, Object> map);

	/**
	 * 
	 * @param conditions
	 * @param map
	 * @return
	 */
	public int getCount(String conditions, Map<String, Object> map);
	
	/**
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int getCount(String sql, Object[] params);

	/**
	 * 
	 * @param sql
	 * @param map
	 * @return
	 */
	public int getCountBySql(String sql, Map<String, Object> map); // 原生sql查出总的记录�?

	/**
	 * 
	 * @param sql
	 * @param map
	 * @return
	 */
	public int getCountBySql(String sql, Object[] params); // 原生sql查出总的记录�?
	/**
	 * 
	 * @param hql
	 * @param map
	 * @return
	 */
	// 执行的hql语句
	/**
	 * 
	 * @param hql
	 * @param map
	 * @return
	 */
	public int executeByHql(String hql, Map<String, Object> map);

	/**
	 * 
	 * @param sql
	 * @param map
	 * @return
	 */
	// 原生的可执行sql语句
	public int executeBySql(String sql, Map<String, Object> map);
	/**
	 * 返回json格式的数�?
	 * @param pageBean
	 * @param map
	 * @param order
	 * @param requset
	 * @param otherParams
	 * @return
	 */
	String getJsonList(PageBean pageBean, Map<String, Object> map,
			String order, HttpServletRequest requset,
			Map<String, Object> otherParams);
	/**
	 * 		返回json格式的数�?
	 * @param pageBean
	 * @param map
	 * @param order
	 * @param requset
	 * @param otherParams
	 * @param excludes
	 * @return
	 */
	String getJsonList(PageBean pageBean, Map<String, Object> map,
			String order, HttpServletRequest requset,
			Map<String, Object> otherParams, String[] excludes);
}
