package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.UesrShopFilter;
import com.eshop.model.UserShopModel;
import com.eshop.service.IUserShopService;

@Component
public class UserShopAction extends EntityCrudAction<UserShopModel> {
	
	@Resource
	private IUserShopService userShopService;
	
	private  UserShopModel userShopModel;
	
	private UesrShopFilter uesrShopFilter;

	public IUserShopService getUserShopService() {
		return userShopService;
	}

	public UserShopModel getUserShopModel() {
		return userShopModel;
	}

	public UesrShopFilter getUesrShopFilter() {
		return uesrShopFilter;
	}

	public void setUserShopService(IUserShopService userShopService) {
		this.userShopService = userShopService;
	}

	public void setUserShopModel(UserShopModel userShopModel) {
		this.userShopModel = userShopModel;
	}

	public void setUesrShopFilter(UesrShopFilter uesrShopFilter) {
		this.uesrShopFilter = uesrShopFilter;
	}
	
}
