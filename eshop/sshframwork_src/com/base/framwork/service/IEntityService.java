package com.base.framwork.service;

import java.util.List;

import com.base.framwork.domain.BaseModel;
import com.base.framwork.domain.IUser;
import com.base.framwork.queryfilter.QueryFilter;

/**
 * 增删改查业务通用接口
 * @author chenas
 *
 * @param <T>
 * 2013.08.11
 */

public interface IEntityService<T extends BaseModel> extends IBaseService {
	
	/**
	 * 根据Id查找
	 * @param id
	 * 			主键
	 * @return
	 */
	public T findEntityById(String id);
	
	/**
	 * 查找数据库中所有的记录
	 * @return
	 */
	public List<T> findEntityList();
	
	/**
	 * 根据过滤器查询所有记录
	 * @param filter
	 * 			过滤器
	 * @return
	 */
	public List<T> findEntityListByFilter(QueryFilter filter);
	
	/**
	 * 插入一条记录
	 * @param entity
	 *            domain对象
	 * @param user
	 * 			操作用户
	 * @return id
	 */
	public String insertEntity(T entity, IUser optUser);

	/**
	 * 删除持久化实体
	 * @param entity
	 * @param optUser
	 */
	public void deleteEntity(T entity, IUser optUser);
	
	/**
	 * 根据主键id删除数据库记录
	 * 
	 * @param id
	 *            主键id
	 * @param optUser
	 *            操作用户
	 *            
	 */         
	public void deleteEntityById(String id, IUser optUser);
	
	/**
	 * 根据ids删除多个数据库记录
	 * 
	 * @param ids
	 *            主键id数组
	 * @param optUser
	 *            操作用户
	 */
	public void deleteManyEntityById(String[] ids, IUser optUser);
	
	/**
	 * 批量删除
	 * @param entitys
	 * @param optUser
	 */
	public void deleteManyEntity(List<T> entitys, IUser optUser);

	/**
	 * 更新数据库记录
	 * 
	 * @param entity
	 *            domain对象
	 * @param optUser
	 *            操作用户
	 */
	public void updateEntity(T entity, IUser optUser);
	
}
