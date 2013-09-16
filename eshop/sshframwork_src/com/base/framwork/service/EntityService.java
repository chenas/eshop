package com.base.framwork.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.base.framwork.domain.BaseModel;
import com.base.framwork.domain.IUser;
import com.base.framwork.queryfilter.QueryFilter;

/**
 * ��ɾ�Ĳ�ͨ��Service
 * @author chenas
 *
 * @param <T>
 * 
 * 2013.09.13
 */

public class EntityService<T extends BaseModel> extends BaseService implements IEntityService<T>{

	/**
	 * ����Id���� load
	 * @param id
	 * 			����
	 * @return
	 */
	@Override
	public T findEntityById(String id) {
		return (T) getCrudDao().loadById(getTClass(), id);
	}

	/**
	 * ����Id���� get
	 * @param id
	 * 			����
	 * @return
	 */
	@Override
	public T getEntityById(String id) {
		return (T) getCrudDao().getById(getTClass(), id);
	}

	/**
	 * �������ݿ������еļ�¼
	 * @return
	 */
	@Override
	public List<T> findEntityList() {
		return getCrudDao().findAllObjList(getTClass().getName());
	}

	/**
	 * ���ݹ�������ѯ���м�¼
	 * @param filter
	 * 			������
	 * @return
	 */
	@Override
	public List<T> findEntityListByFilter(QueryFilter filter) {
		return getCrudDao().findObjListByFilter(getTClass().getName(), filter);
	}

	/**
	 * ����һ����¼
	 * @param entity
	 *            domain����
	 * @param user
	 * 			�����û�
	 * @return id
	 */
	@Override
	public String insertEntity(T entity, IUser optUser) {
		entity.setCreateTime(utilService.getSystemDateTimeString());
		entity.setCreateUser(optUser.getTrueName());
		beforeInsertEntity(entity, optUser);
		getCrudDao().saveOrUpdate(entity);
		afterInsertEntity(entity, optUser);;
		return null;
	}

	//����һ����¼֮ǰ�Ĳ���
	protected void beforeInsertEntity(T entity, IUser optUser){
		
	}
	//����һ����¼֮���Ĳ���
	protected void afterInsertEntity(T entity, IUser optUser){
		
	}


	/**
	 * ɾ���־û�ʵ��
	 * @param entity
	 * @param optUser
	 */
	@Override
	public void deleteEntity(T entity, IUser optUser){
		beforeDeleteEntity(entity, optUser);
		getCrudDao().delObject(entity);
		AfterDeleteEntity(entity, optUser);
		
	}
	
	/**
	 * ��������idɾ�����ݿ���¼
	 * 
	 * @param id
	 *            ����id
	 * @param optUser
	 *            �����û�
	 *            
	 */  
	@Override
	public void deleteEntityById(String id, IUser optUser) {
		beforeDeleteEntity(id, optUser);
		getCrudDao().delById(getTClass(), id);
		AfterDeleteEntity(id, optUser);
	}
	
	//ɾ������֮ǰ
	protected void beforeDeleteEntity(T entity, IUser optUser){
		
	}
	//ɾ������֮��
	protected void AfterDeleteEntity(T entity, IUser optUser){
		
	}
	
	//ɾ������֮ǰ
	protected void beforeDeleteEntity(String id, IUser optUser){
		
	}
	//ɾ������֮��
	protected void AfterDeleteEntity(String id, IUser optUser){
		
	}

	/**
	 * ����idsɾ���������ݿ���¼
	 * 
	 * @param ids
	 *            ����id����
	 * @param optUser
	 *            �����û�
	 */
	@Override
	public void deleteManyEntityById(String[] ids, IUser optUser) {
		if(ids != null && ids.length>0){
			for(int i=0; i<ids.length; i++){
				deleteEntityById(ids[i], optUser);
			}
		}
	}
	
	/**
	 * ����ɾ��
	 * @param entitys
	 * @param optUser
	 */
	@Override
	public void deleteManyEntity(List<T> entitys, IUser optUser){
		if(entitys != null && entitys.size()>0){
			for(int i=0; i<entitys.size(); i++){
				deleteEntity(entitys.get(i), optUser);
			}
		}
	}

	/**
	 * �������ݿ���¼
	 * 
	 * @param entity
	 *            domain����
	 * @param optUser
	 *            �����û�
	 */
	@Override
	public void updateEntity(T entity, IUser optUser) {
		beforUpdate(entity, optUser);
		getCrudDao().saveOrUpdate(entity);
		afterUpdate(entity, optUser);
	}

	//����ǰ����
	protected void beforUpdate(T entity, IUser optUser){
		
	}
	//���º�����
	protected void afterUpdate(T entity, IUser optUser){
		
	}

	/**
	 * ���ݼ�����������ͳ�Ƽ�¼��
	 * @param entity
	 * @param filter
	 * @return
	 */
	@Override
	public int countEntityByFilter(QueryFilter filter){
		return getCrudDao().countObjByFilter(getTClass().getName(), filter);
	}
	
	/**
	 * �Զ���ͳ�Ƽ�¼��
	 * @param entity
	 * @return
	 */
	@Override
	public int countEntityByHql(String hql){
		return getCrudDao().countObjByHql(hql);
	}
	
	//�õ�T.class fdsdfds
	protected Class<T> getTClass(){
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
