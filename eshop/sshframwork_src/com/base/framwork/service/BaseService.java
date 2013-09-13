package com.base.framwork.service;

import com.base.framwork.dao.ICrudDao;

/**
 * IBaseService µœ÷¿‡
 * @author chenas
 * 2013.08.11
 */

public class BaseService implements IBaseService{
	
	private ICrudDao crudDao;
	
	protected IUtilService utilService;

	public IUtilService getUtilService() {
		return utilService;
	}

	public void setUtilService(IUtilService utilService) {
		this.utilService = utilService;
	}

	public ICrudDao getCrudDao() {
		return crudDao;
	}

	public void setCrudDao(ICrudDao crudDao) {
		this.crudDao = crudDao;
	}
	
}
