package com.eshop.domain;

import com.base.framwork.domain.IUser;
import com.eshop.model.UserBuyerModel;

/**
 * userbuyer±íµÄdomain
 * @author chenas
 *
 */
public class UserBuyer extends UserBuyerModel implements IUser{
	
	private String admin;

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@Override
	public String getLoginId() {
		return getName();
	}

	@Override
	public String getTrueName() {
		return getRealname();
	}

	@Override
	public boolean isEnabled() {
		if(getIsValidate().equals("1")){
			return true;
		}
		return false;
	}

}
