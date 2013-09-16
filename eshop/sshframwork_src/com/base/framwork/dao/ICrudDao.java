package com.base.framwork.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import com.base.framwork.queryfilter.QueryFilter;

/**
 * ��ݷ���ͬһ�ӿ�
 * @author chenas
 * 2013��08��11��
 */

public interface ICrudDao extends IBaseDao{
	
	/**
	 *  
	 * @param obj
	 * @return true if success
	 */
	public Boolean save(Object obj);

	/**
	 *  
	 * @param obj
	 * @return true if success
	 */
	public Boolean update(Object obj);
	
	/**
	 * ֱ�Ӵ���ݿ�ȡһ����¼
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object getById(Class clazz, Serializable id);
	
	/** 
	 * ����ָ��ID�ĳ־û�����
	 * 		�˷���ִ��ʱ���ȴӻ���ȡ���󣬻���û�еĻ�����ݿ�ȡ
	 * 		�漰��session����
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object loadById(Class clazz,Serializable id);
	
	/**
	 *  ɾ��ָ��ID�ĳ־û����� 
	 * @param clazz
	 * @param id
	 * @return true if success
	 */
	@SuppressWarnings("rawtypes")
	public Boolean delById(Class clazz,Serializable id);
	
	/**
	 * ɾ��־û�����
	 * @param object
	 * @return true if success
	 */
	public Boolean delObject(Object object);
	
	/**
	 *  ����װ��ָ��������г־û����� 
	 * @param clazz
	 * @return
	 */
	public List findAllObjListByFilter(String clazz, QueryFilter filter);

	/**
	 *  װ��ָ��������г־û����� 
	 * @param clazz
	 * @return
	 */
	public List findAllObjList(String clazz);

	/**
	 * �Զ���װ�س־û����� 
	 * @param hqlString
	 * @param filter
	 * @return
	 */
	public List findObjListByHql(String hqlString);
	
	/**
	 * װ��ָ��������г־û����� 
	 * @param clazz
	 * @param filter
	 * @return
	 */
	public List findObjListByFilter(String clazz,QueryFilter filter);
	
	/**
	 * �Զ���װ�س־û����� 
	 * @param hqlString
	 * @param filter
	 * @return
	 */
	public List findObjListByHqlAndFilter(String hqlString,QueryFilter filter);
	
	/**
	 *  ͳ��ָ��������г־û�������Ŀ
	 * @param clazz
	 * @return
	 */
	public int countObj(String clazz);

	/**
	 * �Զ���Hqlͳ��ָ��������г־û�������Ŀ
	 * @param hqlString
	 * @return
	 */
	public int countObjByHql(String hqlString);
	
	/**
	 *  ��ݹ�������ͳ��ָ��������Ŀ 
	 * @param clazz
	 * @param filter
	 * @return
	 */
	public int countObjByFilter(String clazz, QueryFilter filter);
	
	/**
	 *  ����������� 
	 * @param hqlString
	 * @return �����µ�����
	 */
	public int update(String hqlString);
	
	/**
	 *  �����ӳ���ȡ��һ��JDBC���� 
	 * @return
	 */
	public Connection getConnection();

}
