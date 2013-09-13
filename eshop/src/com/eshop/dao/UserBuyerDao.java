package com.eshop.dao;

import org.springframework.stereotype.Component;

import com.base.framwork.dao.CrudDao;
import com.eshop.dao.impl.IUserBuyerDao;

/**
 * BuyerUserDao操作
 * @author chenas
 * @Component注解可以让spring完成初始化
 *
 */

@Component
public class UserBuyerDao extends CrudDao implements IUserBuyerDao{
	
}
