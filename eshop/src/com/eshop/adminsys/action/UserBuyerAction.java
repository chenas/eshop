package com.eshop.adminsys.action;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.domain.UserBuyer;
import com.eshop.model.UserBuyerModel;

/**
 * 增删改查action
 * @author chenas
 *
 */
@Component
public class UserBuyerAction extends EntityCrudAction<UserBuyerModel>{
	
	private UserBuyer userBuyer;

	public UserBuyerModel getUserBuyerModel() {
		return userBuyer;
	}

	public void setUserBuyerModel(UserBuyer userBuyer) {
		this.userBuyer = userBuyer;
	}

}
