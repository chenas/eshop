package com.base.framwork.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.base.framwork.domain.BaseModel;
import com.base.framwork.domain.IUser;
import com.base.framwork.queryfilter.QueryFilter;

/**
 * 增删改查通用Service
 * @author chenas
 *
 * @param <T>
 * 
 * 2013.09.13
 */

public class EntityService<T extends BaseModel> extends BaseService implements IEntityService<T>{

	/**
	 * 根据Id查找
	 * @param id
	 * 			主键
	 * @return
	 */
	@Override
	public T findEntityById(String id) {
		return (T) getCrudDao().loadById(getTClass(), id);
	}

	/**
	 * 查找数据库中所有的记录
	 * @return
	 */
	@Override
	public List<T> findEntityList() {
		return getCrudDao().findAllObjList(getTClass().getName());
	}

	/**
	 * 根据过滤器查询所有记录
	 * @param filter
	 * 			过滤器
	 * @return
	 */
	@Override
	public List<T> findEntityListByFilter(QueryFilter filter) {
		return getCrudDao().findAllObjListByFilter(getTClass().getName(), filter);
	}

	/**
	 * 插入一条记录
	 * @param entity
	 *            domain对象
	 * @param user
	 * 			操作用户
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

	//新增一条记录之前的操作
	protected void beforeInsertEntity(T entity, IUser optUser){
		
	}
	//新增一条记录之后的操作
	protected void afterInsertEntity(T entity, IUser optUser){
		
	}


	/**
	 * 删除持久化实体
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
	 * 根据主键id删除数据库记录
	 * 
	 * @param id
	 *            主键id
	 * @param optUser
	 *            操作用户
	 *            
	 */  
	@Override
	public void deleteEntityById(String id, IUser optUser) {
		beforeDeleteEntity(id, optUser);
		getCrudDao().delById(getTClass(), id);
		AfterDeleteEntity(id, optUser);
	}
	
	//删除操作之前
	protected void beforeDeleteEntity(T entity, IUser optUser){
		
	}
	//删除操作之后
	protected void AfterDeleteEntity(T entity, IUser optUser){
		
	}
	
	//删除操作之前
	protected void beforeDeleteEntity(String id, IUser optUser){
		
	}
	//删除操作之后
	protected void AfterDeleteEntity(String id, IUser optUser){
		
	}

	/**
	 * 根据ids删除多个数据库记录
	 * 
	 * @param ids
	 *            主键id数组
	 * @param optUser
	 *            操作用户
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
	 * 批量删除
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
	 * 更新数据库记录
	 * 
	 * @param entity
	 *            domain对象
	 * @param optUser
	 *            操作用户
	 */
	@Override
	public void updateEntity(T entity, IUser optUser) {
		beforUpdate(entity, optUser);
		getCrudDao().saveOrUpdate(entity);
		afterUpdate(entity, optUser);
	}

	//更新前操作
	protected void beforUpdate(T entity, IUser optUser){
		
	}
	//更新后操作
	protected void afterUpdate(T entity, IUser optUser){
		
	}

	//得到T.class
	protected Class<T> getTClass(){
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
