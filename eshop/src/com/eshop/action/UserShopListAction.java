package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.eshop.filter.UserShopFilter;
import com.eshop.model.UserShopModel;
import com.eshop.service.IUserShopService;

@Component
public class UserShopListAction extends EntityListAction<UserShopModel> {
	
	@Resource
	private IUserShopService userShopService;

	private UserShopFilter  userShopFilter;

	public UserShopFilter getUserShopFilter() {
		return userShopFilter;
	}

	public void setUserShopFilter(UserShopFilter userShopFilter) {
		this.userShopFilter = userShopFilter;
	}
	
	public IUserShopService getUserShopService() {
		return userShopService;
	}

	public void setUserShopService(IUserShopService userShopService) {
		this.userShopService = userShopService;
	}
}
