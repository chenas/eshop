package com.base.framwork.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import com.base.framwork.queryfilter.QueryFilter;

/**
 * 数据访问同一接口
 * @author chenas
 * 2013年08月11日
 */

public interface ICrudDao extends IBaseDao{
	
	/**
	 *  保存或更新指定的持久化对象 
	 * @param obj
	 * @return true if success
	 */
	public Boolean saveOrUpdate(Object obj);
	
	/**
	 * 直接从数据库取一条记录
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object getById(Class clazz, Serializable id);
	
	/** 
	 * 加载指定ID的持久化对象
	 * 		此方法执行时会先从缓存取对象，缓存没有的话则到数据库取
	 * 		涉及到session问题
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object loadById(Class clazz,Serializable id);
	
	/**
	 *  删除指定ID的持久化对象 
	 * @param clazz
	 * @param id
	 * @return true if success
	 */
	@SuppressWarnings("rawtypes")
	public Boolean delById(Class clazz,Serializable id);
	
	/**
	 * 删除持久化对象
	 * @param object
	 * @return true if success
	 */
	public Boolean delObject(Object object);
	
	/**
	 *  条件装载指定类的所有持久化对象 
	 * @param clazz
	 * @return
	 */
	public List findAllObjListByFilter(String clazz, QueryFilter filter);

	/**
	 *  装载指定类的所有持久化对象 
	 * @param clazz
	 * @return
	 */
	public List findAllObjList(String clazz);

	/**
	 * 自定义装载持久化对象 
	 * @param hqlString
	 * @param filter
	 * @return
	 */
	public List findObjListByHql(String hqlString);
	
	/**
	 * 装载指定类的所有持久化对象 
	 * @param clazz
	 * @param filter
	 * @return
	 */
	public List findObjListByFilter(String clazz,QueryFilter filter);
	
	/**
	 * 自定义装载持久化对象 
	 * @param hqlString
	 * @param filter
	 * @return
	 */
	public List findObjListByHqlAndFilter(String hqlString,QueryFilter filter);
	
	/**
	 *  统计指定类的所有持久化对象数目
	 * @param clazz
	 * @return
	 */
	public int countObj(String clazz);

	/**
	 * 自定义Hql统计指定类的所有持久化对象数目
	 * @param hqlString
	 * @return
	 */
	public int countObjByHql(String hqlString);
	
	/**
	 *  根据过滤条件统计指定对象数目 
	 * @param clazz
	 * @param filter
	 * @return
	 */
	public int countObjByFilter(String clazz, QueryFilter filter);
	
	/**
	 *  条件更新数据 
	 * @param hqlString
	 * @return 被更新的数量
	 */
	public int update(String hqlString);
	
	/**
	 *  从连接池中取得一个JDBC连接 
	 * @return
	 */
	public Connection getConnection();

}
