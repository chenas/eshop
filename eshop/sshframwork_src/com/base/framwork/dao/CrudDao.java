package com.base.framwork.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.base.framwork.queryfilter.QueryFilter;

/**
 * 增删改查DAO
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
	 * 根据filter更新实体
	 * @param clazz
	 * 		com.eshop.model.UserBuyerModel
	 * @param id
	 * 		主键
	 * @param filter
	 * @return
	 * 		更新记录数目
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int updateByFilter(String clazz, String id, QueryFilter filter) throws Exception{
		if(filter != null){
			final String hql = getUpdateSQL(clazz, id, filter);
System.out.println(hql);
			return ((Integer)this.getHibernateTemplate().execute(new HibernateCallback(){
				public Object doInHibernate(Session session) throws HibernateException{
					Query query = session.createQuery(hql);
					return query.executeUpdate();
				}
			})).intValue();
		}
		return 0;
	}	
	/**
	 *  自定义更新
	 * @param hql
	 * @return 
	 * 		更新的记录数目
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
	 *  查找所有实体
	 * @param clazz
	 * @return
	 */
	@Override
	public List findAllObjList(String clazz) {
		return this.getHibernateTemplate().find("from "+clazz+" as a order by a.id desc");
	}

	/**
	 * 自定义查找 
	 * @param hql
	 * @param filter
	 * @return
	 */
	@Override
	public List findObjListByHql(String hql){
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据过滤条件查找实体
	 * 	将条件写出hql语句，赋值给orderByString
	 * @param clazz
	 * 		class name
	 * @return
	 */
	@Override
	public List findAllObjListByFilter(String clazz, QueryFilter filter){
		String hql = "from "+clazz+" as a";
		strBuilder.append(hql);
		strBuilder.append(filter.getQueryString()==null?"" : " "+filter.getQueryString());
		if(filter.getQueryString() !=null && !filter.getOrderByString().equals("")){
			strBuilder.append(" order by a."+filter.getOrderByString());
		}else{
			strBuilder.append(" order by a.id desc");
		}
System.out.println(strBuilder.toString());
		//清空
		strBuilder.setLength(0);
		return this.getHibernateTemplate().find(strBuilder.toString());
	}
	
	/**
	 * 根据过滤条件查找实体
	 * @param clazz
	 * 		class name
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
		strBuilder = strBuilder.append("from "+clazz+ " as a");
		strBuilder.append(filter.getQueryString()==null?"":" "+filter.getQueryString());
		if(filter.getQueryString() != null && !filter.getOrderByString().equals("")){
			strBuilder.append(" order by a."+filter.getOrderByString());
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
		//不分页
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
	 *  根据过滤器统计记录数
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
	 *  获得jdbc连接
	 * @return
	 */
	@Override
	public Connection getConnection() {
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession().connection();
	}
	
	/*
	 * 
	 */
	protected String getSQL(){
		return "";
	}
	
	/**
	 * 由filter传的值获得sql
	 * @param clazz
	 * 		class name
	 * @param id
	 * 		主键
	 * @param filter
	 * @return
	 * 		hql
	 * @throws Exception
	 */
	protected String getUpdateSQL(String clazz, String id, QueryFilter filter) throws Exception{
		strBuilder.append("update "+clazz+" set");
		Class filterClass = filter.getClass();
		Field[] fields = filterClass.getDeclaredFields();
		for(Field field : fields){
			Object value = null;
			if(!field.getName().equals("isLimited") && !field.getName().equals("pageNo") &&
					!field.getName().equals("pageSize") && !field.getName().equals("orderByString") &&
					!field.getName().equals("queryString"))
			{
				value = invokeMethod(filter, field.getName(), null);
				if(value != null){
					if(field.getType().equals(int.class) || field.getType().equals(Double.class)
							|| field.getType().equals(float.class)){
						strBuilder.append(" "+field.getName()+"="+value+",");
					}else if(field.getType().equals(String.class)){
						strBuilder.append(" "+field.getName()+"='"+value+"',");
					}else if(field.getType().equals(Date.class)){
						strBuilder.append(" "+field.getName()+"="+value+",");
					}
					System.out.println(field.getName()+"/t"+value);
				}
			}
		}
		String hql = strBuilder.toString();
		//清空
		strBuilder.setLength(0);
		return hql.substring(0, hql.length()-1)+" where id='"+id+"'";
	}
	

	/**
	 * 获得对象属性的值
	 */
	@SuppressWarnings("unchecked")
	private static Object invokeMethod(Object owner, String methodName,
			Object[] args) throws Exception {
		Class ownerClass = owner.getClass();
		methodName = methodName.substring(0, 1).toUpperCase()
				+ methodName.substring(1);
		Method method = null;
		try {
			method = ownerClass.getMethod("get" + methodName);
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
			return " can't find 'get" + methodName + "' method";
		}
		return method.invoke(owner);
	}
}
