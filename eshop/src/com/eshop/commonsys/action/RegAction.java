package com.eshop.commonsys.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.BaseAction;
import com.eshop.domain.UserBuyer;
import com.eshop.model.UserBuyerModel;
import com.eshop.service.IUserBuyerService;

/**
 * 用户注册action
 * @author chenas
 *
 */
@Component
public class RegAction extends BaseAction{

	@Resource
	private IUserBuyerService userBuyerService;
	
	//用于接收页面的参数
	private UserBuyer userBuyer;
	
	//保存注册信息
	public String register(){
		UserBuyerModel user = new UserBuyerModel();
		user.setName(userBuyer.getName());
		user.setEmail(userBuyer.getEmail());
		user.setPassword(mdcrypt.MD5(userBuyer.getPassword())); //密码md5加密
		userBuyerService.insertEntity(user, userBuyer);
		user = userBuyerService.findEntityById(userBuyerService.hasUser(userBuyer.getName(), null));
		doPutSessionObject("loginUser", user);
		return SUCCESS;  //到首页
	}
	
	//验证用户名是否存在 ajax
	public String hasUser(){
		if(userBuyerService.hasUser(userBuyer.getName(), null) != null){
			return "true";
		}else
			return "false";
	}
	
	//验证用户名是否存在 ajax
	public String hasEmail(){
		if(userBuyerService.hasEmail(userBuyer.getEmail())){
			return "true";
		}else
			return "false";
	}

	public UserBuyer getUserBuyer() {
		return userBuyer;
	}

	public void setUserBuyer(UserBuyer userBuyer) {
		this.userBuyer = userBuyer;
	}
	
}
