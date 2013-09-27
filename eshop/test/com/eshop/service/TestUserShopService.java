package com.eshop.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.domain.UserBuyer;
import com.eshop.model.UserShopModel;

public class TestUserShopService {

	IUserShopService userShopService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userShopService = (IUserShopService) ctx.getBean("userShopService");
	}
	
	@Test
	public void testInsert(){
		UserBuyer user = new UserBuyer();
		user.setName("jack");
		user.setRealname("Tom");
		 
		UserShopModel us = new UserShopModel();
		us.setName("usst");
		us.setStoreName("my");
		us.setStoreId("123");
		us.setPassword("1232455654");
		us.setIsEshop("0");
		userShopService.insertEntity(us, user);
		
	}
	
	@Test
	public void testFindAllList(){
		UserBuyer user = new UserBuyer();
		user.setName("jack");
		user.setRealname("Tom");
		List<UserShopModel> lists = userShopService.findEntityList();
		for(int i=0; i<lists.size(); i++){
			userShopService.deleteEntity(lists.get(i), user);
		}
	}

}
