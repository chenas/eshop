package com.eshop.commonsys.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityBaseAction;
import com.base.framwork.domain.IUser;
import com.eshop.domain.UserBuyer;
import com.eshop.model.UserBuyerModel;
import com.eshop.service.IUserBuyerService;

/**
 * 登录action
 * @author chenas
 *
 */
@Component
public class BuyerLoginAction extends EntityBaseAction<UserBuyerModel> {

	private String name;
	private String password;
	
	@Resource
	private IUserBuyerService userBuyerService;
	
	@Override
	public String execute() throws Exception {
		if(userBuyerService.hasUser(name, password) != null){
			UserBuyerModel user = userBuyerService.findEntityById(userBuyerService.hasUser(name, password));
			doPutSessionObject("loginUser", user); //将用户放进session里面
			return SUCCESS; //到首页
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
