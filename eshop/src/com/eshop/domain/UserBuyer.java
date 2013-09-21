package com.eshop.domain;

import com.base.framwork.domain.IUser;
import com.eshop.model.UserBuyerModel;

/**
 * userbuyer domain 域模型对象
 * @author chenas
 *
 */
public class UserBuyer extends UserBuyerModel implements IUser{
	
	/**
	 * 如果是admin的话设置其角色名称
	 * 其他的则为空
	 */
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
