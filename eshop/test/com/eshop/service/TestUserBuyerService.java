package com.eshop.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.base.framwork.queryfilter.QueryFilter;
import com.eshop.domain.UserBuyer;
import com.eshop.model.UserBuyerModel;

public class TestUserBuyerService {
	
	IUserBuyerService userBuyerService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userBuyerService = (IUserBuyerService) ctx.getBean("userBuyerService");
	}

	@Test
	public void testInsert(){
		UserBuyerModel user = new UserBuyerModel();
		UserBuyer opt = new UserBuyer();
		opt.setName("jack");
		opt.setRealname("jack");
		user.setName("Tom");
		user.setPassword("1234");
		user.setIsValidate("0");
		userBuyerService.insertEntity(user, opt);
	}
	@Test
	public void testFindEntityListByFilter(){
		QueryFilter filter = new QueryFilter();
		List<UserBuyerModel> users = userBuyerService.findEntityListByFilter(filter);
		for(int i=0; i<users.size(); i++){
			System.out.println(users.get(i).getName());
		}
	}
	@Test
	public void testHasUser(){
		QueryFilter filter = new QueryFilter();
		System.out.println(userBuyerService.hasUser("Tom", "1234"));
		System.out.println(userBuyerService.countEntityByFilter(filter));
	}
}
