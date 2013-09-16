package com.eshop.adminsys.action;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.model.UserBuyerModel;

/**
 * 增删改查action
 * @author chenas
 *
 */
@Component
public class UserBuyerAction extends EntityCrudAction<UserBuyerModel>{
	
	private UserBuyerModel userBuyerModel;

	public UserBuyerModel getUserBuyerModel() {
		return userBuyerModel;
	}

	public void setUserBuyerModel(UserBuyerModel userBuyerModel) {
		this.userBuyerModel = userBuyerModel;
	}

}
