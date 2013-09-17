package com.eshop.adminsys.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.eshop.model.UserBuyerModel;
import com.eshop.service.IUserBuyerService;

@Component
public class UserBuyerListAction extends EntityListAction<UserBuyerModel>{

	@Resource
	private IUserBuyerService userBuyerService;
	
}

