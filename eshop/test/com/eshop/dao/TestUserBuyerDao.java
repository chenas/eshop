package com.eshop.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.dao.IUserBuyerDao;
import com.eshop.model.UserBuyerModel;

public class TestUserBuyerDao {
	
	IUserBuyerDao buyerDao;
	
	@Before
	public void init(){

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		buyerDao = (IUserBuyerDao) ctx.getBean("userBuyerDao");
	}

	@Test
	public void testSave(){
		for(int i=0; i<5;i++){
			//��unknown entity exception
//			UserBuyer buyer = new UserBuyer();
			
			UserBuyerModel buyer = new UserBuyerModel();
			buyer.setPassword("23423432");
			buyer.setName("jack");
			buyer.setIsValidate("0");
			buyerDao.save(buyer);
		}
	}
	@Test
	public void testFindAll(){
		System.out.println(UserBuyerModel.class.getName());
		List<UserBuyerModel> users = buyerDao.findAllObjList(UserBuyerModel.class.getName());
		System.out.println(users.size());
	}
	@Test
	public void testLoadObjById(){
		UserBuyerModel user = (UserBuyerModel) buyerDao.getById(UserBuyerModel.class, "152dfcbc-01b6-443d-9648-3356218c6201");
		System.out.println(user.getName());
	}
}
