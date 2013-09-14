package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityBaseAction;
import com.eshop.model.UserBuyerModel;
import com.eshop.service.IUserBuyerService;

@Component
public class BuyerLoginAction extends EntityBaseAction<UserBuyerModel> {

	private String name;
	private String password;
	
	@Resource
	private IUserBuyerService userBuyerService;
	
	@Override
	public String execute() throws Exception {
		if(userBuyerService.hasUser(name, password)){
			return SUCCESS;
		}else
			return ERROR;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
