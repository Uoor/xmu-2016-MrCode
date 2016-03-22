package com.mrcode.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mrcode.utils.DataUtils;
import com.mrcode.utils.PageBean;

/**
 * 
 * @author 羽中
 * 
 * @param <T>
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		// 得到超类的泛型化方法
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	/**
	 * 保存�?��实体对象
	 */
	public Integer save(T model) {
		return (Integer) hibernateTemplate.save(model);
	}

	/**
	 * 更新�?��实体
	 */
	public void update(T model) {
		hibernateTemplate.update(model);

	}

	/**
	 * 保存或�?更新�?��对象
	 */
	public void saveOrUpdate(T model) {
		hibernateTemplate.saveOrUpdate(model);

	}

	/**
	 * 根据id获取实体
	 */
	public T getById(Integer id) {
		if (id == null) {
			return null;
		} else {
			return hibernateTemplate.get(clazz, id);
		}
	}

	/**
	 * 根据id数组获取集合
	 */
	@SuppressWarnings("unchecked")
	public List<T> getByIds(Integer[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		} else {
			return this.hibernateTemplate
					.getSessionFactory()
					.getCurrentSession()
					.createQuery(//
							"FROM " + clazz.getSimpleName()
									+ " WHERE id IN (:ids)")//
					.setParameterList("ids", ids)//
					.list();
		}
	}

	// 物理删除，直接删除数�?
	public void remove(Integer id) {
		hibernateTemplate.delete(getById(id));
	}

	// 逻辑删除，并不直接删除，而是将delflag字段�?
	public boolean delete(Integer id) {
		if (id == null) {
			return false;
		} else {
			int result = executeByHql("update " + clazz.getName()
					+ " set delFlag = 0 where id= " + id, null);
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	/********************* Begin:查询数据集合 ***********************/
	@SuppressWarnings("unchecked")
	public List<T> findByHql(String hql, Map<String, Object> map,
			PageBean pageBean, String order) {
		hql += StringUtils.isEmpty(order) ? "" : " order by " + order;
		//hql = filter(hql, map);
		System.out.println("hql->" + hql);
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		setPage(query, pageBean);
		setQuery(map, query);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByHql(String hql, Object[] params, PageBean pageBean,
			String order) {
		//hql = filter(hql);
		hql += StringUtils.isEmpty(order) ? "" : " order by " + order;
		System.out.println("hql->" + hql);
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		setPage(query, pageBean);
		setQuery(params, query);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public T findUniqueByHql(String hql, Map<String, Object> map) {
		//hql = filter(hql, map);
		System.out.println("hql->"+hql);
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		setQuery(map, query);
		return (T) query.uniqueResult();
	}

	// 根据sql语句查询
	@SuppressWarnings("unchecked")
	public List<T> findBySql(String sql, Map<String, Object> map,
			PageBean pageBean, String order) {
		//sql = filter(sql, map);
		sql += (StringUtils.isEmpty(order)) ? "" : " order by " + order;
		System.out.println("sql->" + sql);
		SQLQuery query = hibernateTemplate.getSessionFactory()
				.getCurrentSession().createSQLQuery(sql);
		setPage(query, pageBean);
		setQuery(map, query);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List findBySql(String sql, Object[] params,
			PageBean pageBean, String order) {
		sql += (StringUtils.isEmpty(order)) ? "" : " order by " + order;
		System.out.println("sql->" + sql);
		SQLQuery query = hibernateTemplate.getSessionFactory()
				.getCurrentSession().createSQLQuery(sql);
		setPage(query, pageBean);
		setQuery(params, query);
		return query.list();
	}
	

	@SuppressWarnings("unchecked")
	public List<Object[]> findObjectsBySql(String sql, Map<String, Object> map) {
		System.out.println("sql->" + sql);
		SQLQuery query = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createSQLQuery(sql);
		setQuery(map, query);
		return query.list();
	}

	/******************* End:查询数据集合 ***********************/
	/********************* Begin: 查询总数�?*************/
	public int getCount(Map<String, Object> map) {
		return getCount(DataUtils.getHql(map), map);
	}

	public int getCount(String conditions, Map<String, Object> map) {
		String hql = "select count(*) from " + clazz.getName() + conditions;
		//hql = filter(hql, map);
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		setQuery(map, query);
		return Integer.parseInt(query.uniqueResult().toString());
	}

	public int getCount(String conditions, Object[] params) {
		String hql = "select count(*) from " + clazz.getName() + conditions;
		//hql = filter(hql);
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		setQuery(params, query);
		return Integer.parseInt(query.uniqueResult().toString());
	}

	public int getCountBySql(String sql, Map<String, Object> map) {
		//sql = filter(sql, map);
		SQLQuery query = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createSQLQuery(sql);
		setQuery(map, query);
		return Integer.parseInt(query.uniqueResult().toString());
	}

	public int getCountBySql(String sql, Object[] params) {
		//sql = filter(sql, map);
		SQLQuery query = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createSQLQuery(sql);
		setQuery(params, query);
		return Integer.parseInt(query.uniqueResult().toString());
	}
	/******************* End:查询总数�?*************/
	/******************* Begin:可执行语�?*************/
	public int executeByHql(String hql, Map<String, Object> map) {
		// 根据�?��hql语句创建�?��Query对象
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		setQuery(map, query);
		return query.executeUpdate();
	}

	public int executeBySql(String sql, Map<String, Object> map) {
		SQLQuery query = hibernateTemplate.getSessionFactory()
				.getCurrentSession().createSQLQuery(sql);
		if (map != null) {
			setQuery(map, query);
		}
		return query.executeUpdate();
	}

	/******************* End:可执行语�?*************/
	// 根据map设置参数
	private void setQuery(Map<String, Object> map, Query query) {
		if (map == null) {
			return;
		} else {
			for (Entry<String, Object> entry : map.entrySet()) {
				String key = entry.getKey();
				if (key.indexOf("|") > 0) {
					key = key.split("\\|")[0];
				}
				Object value = entry.getValue();
				key = key.replaceAll("\\.", "_");
				if (value instanceof Integer) {
					query.setInteger(key, Integer.parseInt(value.toString()));
				} else if (value instanceof String) {
					query.setString(key, value.toString());
				} else {
					query.setParameter(key, value);
				}
			}
		}
	}

	// 根据参数数组依次设置参数
	private void setQuery(Object[] params, Query query) {
		if (params == null || params.length == 0) {
			return;
		} else {
			try {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	// 设置查询语句过滤
	private static String filter(String str, Map<String, Object> map) {
		if ((map != null && map.get("delFlag") != null
				&& !map.get("delFlag").toString().equals(""))||str.toUpperCase().indexOf("DELFLAG")>0) {
			return str;
		} else {
			String order = "";
			int orderIndex;
			int whereIndex;
			orderIndex = str.toUpperCase().indexOf(" ORDER ");
			// 判断是否存在ORDER语句
			if (orderIndex > 0) {
				order = str.substring(orderIndex, str.length());
				str = str.substring(0, orderIndex);
			}
			// 判断是否存在WHERE语句
			whereIndex = str.toUpperCase().indexOf(" WHERE ");
			if (whereIndex > 0) {
				str += " and delFlag=1 " + order;
			} else {
				str += " where delFlag=1 " + order;
			}
			return str;
		}
	}

	// 设置查询语句过滤
		private static String filter(String str) {
			if (str.toUpperCase().indexOf("DELFLAG")>0) {
				return str;
			} else {
				String order = "";
				int orderIndex;
				int whereIndex;
				orderIndex = str.toUpperCase().indexOf(" ORDER ");
				// 判断是否存在ORDER语句
				if (orderIndex > 0) {
					order = str.substring(orderIndex, str.length());
					str = str.substring(0, orderIndex);
				}
				// 判断是否存在WHERE语句
				whereIndex = str.toUpperCase().indexOf(" WHERE ");
				if (whereIndex > 0) {
					str += " and delFlag=1 " + order;
				} else {
					str += " where delFlag=1 " + order;
				}
				return str;
			}
		}
		
	private void setPage(Query query, PageBean pageBean) {
		if (pageBean != null) {
			query.setFirstResult(pageBean.countOffSet()).setMaxResults(
					pageBean.getPageSize());
		}
	}


}
