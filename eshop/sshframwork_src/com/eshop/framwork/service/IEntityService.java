package com.eshop.framwork.service;

import java.util.List;

import com.eshop.framwork.domain.BaseModel;
import com.eshop.framwork.domain.IUser;
import com.eshop.framwork.queryfilter.IFilter;

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
	public T findEntityById(long id);
	
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
	public List<T> findEntityListByFilter(IFilter filter);
	
	/**
	 * 根据过滤器查询所有记录
	 * @param filter
	 * @param isLimited 
	 * 			true表示进行分页
	 * 			false表示不进行分页
	 * @return
	 */
	public List<T> findEntityListByFilter(IFilter filter, Boolean isLimited);
	
	/**
	 * 插入一条记录
	 * @param entity
	 *            domain对象
	 * @param user
	 * 			操作用户
	 * @return id
	 */
	public long insertEntity(T entity, IUser optUser);
	public long insertEntity(T entity);
	

	/**
	 * 根据主键id删除数据库记录
	 * 
	 * @param id
	 *            主键id
	 * @param optUser
	 *            操作用户
	 *            
	 */         
	 
	public void deleteEntityById(long id, IUser optUser);
	
	/**
	 * 根据ids删除多个数据库记录
	 * 
	 * @param ids
	 *            主键id数组
	 * @param optUser
	 *            操作用户
	 */
	public void deleteManyEntityById(long[] ids, IUser optUser);

	/**
	 * 更新数据库记录
	 * 
	 * @param entity
	 *            domain对象
	 * @param optUser
	 *            操作用户
	 */
	public void updateEntity(T entity, IUser optUser);
	
	/**
	 * 根据过滤器更新数据库记录
	 * @param entity
	 *            domain对象
	 * @param filter
	 * @param optUser
	 */
	public void updateEntityByFilter(T entity, IFilter filter, IUser optUser);
	
}
