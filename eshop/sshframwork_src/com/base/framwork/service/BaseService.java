package com.base.framwork.service;

import javax.annotation.Resource;

import com.base.framwork.dao.ICrudDao;

/**
 * IBaseServiceʵ����
 * @author chenas
 * 2013.08.11
 */
public class BaseService implements IBaseService{
	
	@Resource
	private ICrudDao crudDao;

	@Resource
	protected IUtilService utilService;

	public IUtilService getUtilService() {
		return utilService;
	}
	
	public ICrudDao getCrudDao() {
		return crudDao;
	}
	
}
