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
import org.springframework.stereotype.Component;

import com.base.framwork.queryfilter.QueryFilter;

/**
 * ICrudDaoʵ����
 * @author chenas
 * 2013.08.11
 */
public class CrudDao extends BaseDao implements ICrudDao{

	private static StringBuilder strBuilder = new StringBuilder();
	
	/**
	 *  
	 * @param obj
	 * @return true if success
	 */
	@Override
	public Boolean save(Object obj) {
		try{
			this.getHibernateTemplate().save(obj);
		}catch(DataAccessException ex){
			return false;
		}
		return true;
	}
	
	/**
	 *  
	 * @param obj
	 * @return true if success
	 */
	@Override
	public Boolean update(Object obj) {
		try{
			this.getHibernateTemplate().update(obj);
		}catch(DataAccessException ex){
			return false;
		}
		return true;
	}

	/**
	 * ֱ�Ӵ���ݿ�ȡһ����¼
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object getById(Class clazz, Serializable id){
		Object entity = null;
		try{
			entity = this.getHibernateTemplate().get(clazz, id);
		}catch(Exception ex){
			return null;
		}
		return entity;
	}
	
	/** 
	 * ����ָ��ID�ĳ־û����� 
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
	 *  ɾ��ָ��ID�ĳ־û����� 
	 * @param clazz
	 * @param id
	 * @return true if success
	 */
	@Override
	public Boolean delById(Class clazz, Serializable id) {
		return delObject(this.getHibernateTemplate().load(clazz, id));
	}


	/**
	 * ɾ��־û�����
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
	 *  װ��ָ��������г־û����� 
	 * @param clazz
	 * @return
	 */
	@Override
	public List findAllObjList(String clazz) {
		return this.getHibernateTemplate().find("from "+clazz+" as a order by a.id desc");
	}

	/**
	 * �Զ���װ�س־û����� 
	 * @param hql
	 * @param filter
	 * @return
	 */
	@Override
	public List findObjListByHql(String hql){
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ����װ��ָ��������г־û����� 
	 * @param clazz
	 * @return
	 */
	@Override
	public List findAllObjListByFilter(String clazz, QueryFilter filter){
		String hql = "from "+clazz+" as a";
		strBuilder.append(hql);
		strBuilder.append(filter.getQueryString()==null?"" : " "+filter.getQueryString());
		if(filter.getQueryString() !=null && !filter.getOrderByString().equals("")){
			strBuilder.append(" "+filter.getOrderByString());
		}else{
			strBuilder.append(" order by a.id desc");
		}
System.out.println(strBuilder.toString());
		//清空
		strBuilder.setLength(0);
		return this.getHibernateTemplate().find(strBuilder.toString());
	}
	
	/**
	 * ��ҳװ��ָ��������г־û����� 
	 * @param clazz
	 * @return
	 */
	@Override
	public List findObjListByFilter(String clazz, QueryFilter filter) {
		//����ҳ
		if(filter.isLimited() == false){
			findAllObjListByFilter(clazz, filter);
		}
		final int pNo = filter.getPageNo();
		final int pSize = filter.getPageSize();
		strBuilder = strBuilder.append("from "+clazz+ " as a");
		strBuilder.append(filter.getQueryString()==null?"":" "+filter.getQueryString());
		if(filter.getQueryString() != null && !filter.getOrderByString().equals("")){
			strBuilder.append(" "+filter.getOrderByString());
		}else{
			strBuilder.append(" order by a.id desc");
		}
		final String hql = strBuilder.toString();
System.out.println(hql);
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
		//清空
		strBuilder.setLength(0);
		return list;
	}

	/**
	 * �Զ���װ�س־û����� 
	 * @param hql
	 * @param filter
	 * @return
	 */
	@Override
	public List findObjListByHqlAndFilter(String hql,QueryFilter filter){
		//����ҳ
		if(filter.isLimited() == false){
			findObjListByHql(hql);
		}
		final int pNo = filter.getPageNo();
		final int pSize = filter.getPageSize();
		final String hqlexe = hql;
System.out.println(hql);
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
	 *  ͳ��ָ��������г־û����� ����
	 * @param clazz
	 * @return
	 */
	@Override
	public int countObj(String clazz) {
		final String hql = "select count(*) from "+clazz+ " as a";
System.out.println(hql);
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
	 * �Զ���Hqlͳ��ָ��������г־û�������Ŀ
	 * @param hql
	 * @return
	 */
	@Override
	public int countObjByHql(String hql){
		final String hqlexe = hql;
System.out.println(hql);
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
	 *  ��ݹ�������ͳ��ָ��������Ŀ 
	 * @param clazz
	 * @param filter
	 * @return
	 */
	@Override
	public int countObjByFilter(String clazz, QueryFilter filter) {
		strBuilder.append("select count(*) from "+clazz+ " as a");
		strBuilder.append(filter.getQueryString()==null?"":" "+filter.getQueryString());
		final String hql = strBuilder.toString();
System.out.println(hql);
		@SuppressWarnings("unchecked")
		Long count = (Long)this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql);
				query.setMaxResults(1);
				return query.uniqueResult();
			}
		});	
		//清空
		strBuilder.setLength(0);
		return count.intValue();
	}

	/**
	 *  ����������� 
	 * @param hql
	 * @return �����µ�����
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int update(String hql) {
		final String hql1 = hql;
System.out.println(hql);
		return ((Integer)this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql1);
				return query.executeUpdate();
			}
		})).intValue();
	}

	/**
	 *  �����ӳ���ȡ��һ��JDBC���� 
	 * @return
	 */
	@Override
	public Connection getConnection() {
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession().connection();
	}
	
	/*
	 * ƴ����ݲ������
	 */
	protected String getSQL(){
		return "";
	}

}
