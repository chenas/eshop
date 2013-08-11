package com.eshop.framwork.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import com.eshop.framwork.queryfilter.IFilter;
import com.eshop.framwork.queryfilter.QueryFilter;

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
	 * 加载指定ID的持久化对象 
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
	 *  装载指定类的所有持久化对象 
	 * @param clazz
	 * @return
	 */
	public List findObjList(String clazz);
	
	/**
	 *  分页装载指定类的所有持久化对象 
	 * @param clazz
	 * @param filter
	 * @return
	 */
	public List findObjListByFilter(String clazz,IFilter filter);
	
	/**
	 *  统计指定类的所有持久化对象 
	 * @param clazz
	 * @return
	 */
	public int countObj(String clazz);
	
	/**
	 *  根据过滤条件统计指定对象 
	 * @param clazz
	 * @param filter
	 * @return
	 */
	public int countObjByFilter(String clazz, IFilter filter);
	
	/**
	 *  条件更新数据 
	 * @param hql
	 * @return 被更新的数量
	 */
	public int update(String hql, IFilter filter);
	
	/**
	 *  从连接池中取得一个JDBC连接 
	 * @return
	 */
	public Connection getConnection();

}
