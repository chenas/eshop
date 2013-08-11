package com.eshop.framwork.service;

import com.eshop.framwork.dao.IBaseDao;

/**
 * IBaseService µœ÷¿‡
 * @author chenas
 * 2013.08.11
 */

public class BaseService implements IBaseService{
	
	private IBaseDao crudDao;

	public IBaseDao getCrudDao() {
		return crudDao;
	}

	public void setCrudDao(IBaseDao crudDao) {
		this.crudDao = crudDao;
	}
	
}
