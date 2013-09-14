package com.eshop.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.base.framwork.service.EntityService;
import com.eshop.model.UserBuyerModel;
import com.eshop.service.IUserBuyerService;

/**
 * userbuyer业务操作实现
 * @author chenas
 *
 */
@Component
public class UserBuyerService extends EntityService<UserBuyerModel> implements IUserBuyerService{
	
	/**
	 * 用户名密码是否正确,也可用于用户名是否重复的验证
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean hasUser(String name, String password){
		List<UserBuyerModel> user = null;
		if(password == null || password.equals("")){
			user = getCrudDao().findObjListByHql("from USER_BUYER as a where a.name='"+name+"'");
		}else{
			user = getCrudDao().findObjListByHql("from USER_BUYER as a where a.name='"+name+"' and a.password='"+utilService.getMD5String(password)+"'");
		}
		if(user != null && user.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
}
