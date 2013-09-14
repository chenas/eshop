package com.eshop.service;

import com.base.framwork.service.IEntityService;
import com.eshop.model.UserBuyerModel;

public interface IUserBuyerService extends IEntityService<UserBuyerModel>{
	
	/**
	 * 用户名密码是否正确
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean hasUser(String name, String password);
	
}
