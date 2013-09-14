package com.eshop.dao.impl;

import org.springframework.stereotype.Component;

import com.base.framwork.dao.CrudDao;
import com.eshop.dao.IUserBuyerDao;

/**
 * BuyerUserDao操作
 * @author chenas
 * @Component注解可以让spring完成初始化
 *
 */
@Component
public class UserBuyerDao extends CrudDao implements IUserBuyerDao{
	
}
