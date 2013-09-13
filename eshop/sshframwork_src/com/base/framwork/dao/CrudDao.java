package com.base.framwork.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.base.framwork.queryfilter.QueryFilter;

/**
 * ICrudDao实现类
 * @author chenas
 * 2013.08.11
 */

public class CrudDao extends BaseDao implements ICrudDao{

	/**
	 *  保存或更新指定的持久化对象 
	 * @param obj
	 * @return true if success
	 */
	@Override
	public Boolean saveOrUpdate(Object obj) {
		try{
			this.getHibernateTemplate().saveOrUpdate(obj);
		}catch(DataAccessException ex){
			return false;
		}
		return true;
	}

	/** 
	 * 加载指定ID的持久化对象 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@Override
	public Object loadById(Class clazz, Serializable id) {
		Object entity = null;
		try{
			entity = this.getHibernateTemplate().load(clazz, id);
		}catch(Exception ex){
			return null;
		}
		return entity;
	}


	/**
	 *  删除指定ID的持久化对象 
	 * @param clazz
	 * @param id
	 * @return true if success
	 */
	@Override
	public Boolean delById(Class clazz, Serializable id) {
		return delObject(this.getHibernateTemplate().load(clazz, id));
	}


	/**
	 * 删除持久化对象
	 * @param object
	 * @return true if success
	 */
	@Override
	public Boolean delObject(Object object) {
		try{
			this.getHibernateTemplate().delete(object);
		}catch(DataAccessException ex){
			return false;
		}
		return true;
	}

	/**
	 *  装载指定类的所有持久化对象 
	 * @param clazz
	 * @return
	 */
	@Override
	public List findAllObjList(String clazz) {
		return this.getHibernateTemplate().find("from "+clazz+" as a order by a.id desc");
	}

	/**
	 * 自定义装载持久化对象 
	 * @param hql
	 * @param filter
	 * @return
	 */
	@Override
	public List findObjListByHql(String hql){
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 条件装载指定类的所有持久化对象 
	 * @param clazz
	 * @return
	 */
	@Override
	public List findAllObjListByFilter(String clazz, QueryFilter filter){
		String hql = "from "+clazz+" as a "+filter.getQueryString();
		if(!filter.getOrderByString().equals("")){
			hql += filter.getOrderByString();
		}else{
			hql += "order by a.id desc";
		}
		return this.getHibernateTemplate().find(hql);
	}
	
	/**
	 * 分页装载指定类的所有持久化对象 
	 * @param clazz
	 * @return
	 */
	@Override
	public List findObjListByFilter(String clazz, QueryFilter filter) {
		//不分页
		if(filter.isLimited() == false){
			findAllObjListByFilter(clazz, filter);
		}
		final int pNo = filter.getPageNo();
		final int pSize = filter.getPageSize();
		String hqlString = "from "+clazz+ " as a "+filter.getQueryString();
		if(!filter.getOrderByString().equals("")){
			hqlString += filter.getOrderByString();
		}else{
			hqlString += "order by a.id desc";
		}
		final String hql = hqlString;
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql);
				query.setMaxResults(pSize);
				query.setFirstResult((pNo-1)*pSize);
				List result = query.list();
				if (!Hibernate.isInitialized(result))Hibernate.initialize(result);
				return result;
			}
		});	
		return list;
	}

	/**
	 * 自定义装载持久化对象 
	 * @param hql
	 * @param filter
	 * @return
	 */
	@Override
	public List findObjListByHqlAndFilter(String hql,QueryFilter filter){
		//不分页
		if(filter.isLimited() == false){
			findObjListByHql(hql);
		}
		final int pNo = filter.getPageNo();
		final int pSize = filter.getPageSize();
		final String hqlexe = hql;
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hqlexe);
				query.setMaxResults(pSize);
				query.setFirstResult((pNo-1)*pSize);
				List result = query.list();
				if (!Hibernate.isInitialized(result))Hibernate.initialize(result);
				return result;
			}
		});	
		return list;
	}

	/**
	 *  统计指定类的所有持久化对象 总数
	 * @param clazz
	 * @return
	 */
	@Override
	public int countObj(String clazz) {
		final String hql = "select count(*) from "+clazz+ " as a";
		@SuppressWarnings("unchecked")
		Long count = (Long)this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql);
				query.setMaxResults(1);
				return query.uniqueResult();
			}
		});	
		return count.intValue();
	}

	/**
	 * 自定义Hql统计指定类的所有持久化对象数目
	 * @param hql
	 * @return
	 */
	@Override
	public int countObjByHql(String hql){
		final String hqlexe = hql;
		@SuppressWarnings("unchecked")
		Long count = (Long)this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hqlexe);
				query.setMaxResults(1);
				return query.uniqueResult();
			}
		});	
		return count.intValue();
	}

	/**
	 *  根据过滤条件统计指定对象数目 
	 * @param clazz
	 * @param filter
	 * @return
	 */
	@Override
	public int countObjByFilter(String clazz, QueryFilter filter) {
		final String hql = "select count(*) from "+clazz+ " as a "+filter.getQueryString();
		@SuppressWarnings("unchecked")
		Long count = (Long)this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql);
				query.setMaxResults(1);
				return query.uniqueResult();
			}
		});	
		return count.intValue();
	}

	/**
	 *  条件更新数据 
	 * @param hql
	 * @return 被更新的数量
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int update(String hql) {
		final String hql1 = hql; 
		return ((Integer)this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql1);
				return query.executeUpdate();
			}
		})).intValue();
	}

	/**
	 *  从连接池中取得一个JDBC连接 
	 * @return
	 */
	@Override
	public Connection getConnection() {
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession().connection();
	}
	
	/*
	 * 拼接数据操作语句
	 */
	protected String getSQL(){
		return "";
	}

}
