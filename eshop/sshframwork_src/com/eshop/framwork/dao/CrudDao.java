package com.eshop.framwork.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.eshop.framwork.queryfilter.ConditionFilter;
import com.eshop.framwork.queryfilter.IFilter;

/**
 * ICrudDao µœ÷¿‡
 * @author chenas
 * 2013.08.11
 */

public class CrudDao extends BaseDao implements ICrudDao{

	@Override
	public Boolean saveOrUpdate(Object obj) {
		try{
			this.getHibernateTemplate().saveOrUpdate(obj);
		}catch(DataAccessException ex){
			return false;
		}
		return true;
	}

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

	@Override
	public Boolean delById(Class clazz, Serializable id) {
		return delObject(this.getHibernateTemplate().load(clazz, id));
	}

	@Override
	public Boolean delObject(Object object) {
		try{
			this.getHibernateTemplate().delete(object);
		}catch(DataAccessException ex){
			return false;
		}
		return true;
	}

	@Override
	public List findObjList(String clazz) {
		return this.getHibernateTemplate().find("from "+clazz+" as a order by a.id desc");
	}

	@Override
	public List findObjListByFilter(String clazz, IFilter filter) {
		if(filter.isLimited() == false){
			
		}
		final int pNo = filter.getPageNo();
		final int pSize = filter.getPageSize();
		final String hql = "from "+clazz+ " as a order by a.id desc";
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
	
	public List findObjListByFilter(String clazz, IFilter filter, boolean isLimited){
		final String hql = "from "+clazz+ " as a order by a.id desc";
		
		for(int i=0; i<filter.getLstCondition().size(); i++){
			
		}
		return null;
	}

	@Override
	public int countObj(String clazz) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countObjByFilter(String clazz, IFilter filter) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String hql, IFilter filter) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
