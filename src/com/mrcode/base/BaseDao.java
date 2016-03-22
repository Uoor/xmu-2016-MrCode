package com.mrcode.base;


import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mrcode.utils.PageBean;

/**
 * 
 * @author 羽中
 *
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 保存实体
	 * @param model
	 * @return 主键
	 */
	public Integer save(T model);

	/**
	 * 
	 * @param model
	 */
	public void update(T model);

	/**
	 * 
	 * @param model
	 */
	public void saveOrUpdate(T model);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public T getById(Integer id);

	/**
	 * 
	 * @param ids
	 * @return
	 */
	public List<T> getByIds(Integer[] ids);

	/**
	 * 物理删除，直接删除数据
	 * @param id
	 */
	public void remove(Integer id);

	/**
	 * 逻辑删除，并不直接删除，而是将delflag字段置0
	 * @param id
	 * @return
	 */
	public boolean delete(Integer id);

	/**************** hql语句执行的操作 *******************/
	/**
	 * 根据hql语句查询出一个集合
	 * @param hql
	 * @param map
	 * @param pageBean
	 * @param order
	 * @return
	 */
	public List<T> findByHql(String hql, Map<String, Object> map,
			PageBean pageBean, String order);
	/**
	 * 
	 * @param hql
	 * @param params
	 * @param pageBean
	 * @param order
	 * @return
	 */
	public List<T> findByHql(String hql, Object[] params,
			PageBean pageBean, String order);
	/**
	 * 根据sql语句查询出一个集合
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
	public List findBySql(String sql, Object[] params,
			PageBean pageBean, String order);

	/**
	 * 查询实体类中的某些属性
	 * @param sql
	 * @param map
	 * @return
	 */
	public List<Object[]> findObjectsBySql(String sql, Map<String, Object> map);

	/**
	 * 
	 * @param hql
	 * @param map
	 * @return
	 */
	public T findUniqueByHql(String hql, Map<String, Object> map);
	
	/**
	 * 查询总的记录数
	 * @param map
	 * @return
	 */
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
	 * @param conditions
	 * @param params
	 * @return
	 */
	public int getCount(String sql, Object[] params);

	/**
	 * 原生sql查出总的记录数
	 * @param sql
	 * @param map
	 * @return
	 */
	public int getCountBySql(String sql, Map<String, Object> map); 
	/**
	 * 原生sql查出总的记录数
	 * @param sql
	 * @param map
	 * @return
	 */
	public int getCountBySql(String sql, Object[] params);

	/**
	 * 执行的hql语句
	 * @param hql
	 * @param map
	 * @return
	 */
	public int executeByHql(String hql, Map<String, Object> map);

	/**
	 * 原生的可执行sql语句
	 * @param sql
	 * @param map
	 * @return
	 */
	public int executeBySql(String sql, Map<String, Object> map);

	
}
