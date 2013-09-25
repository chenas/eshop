package com.eshop.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.domain.UserBuyer;
import com.eshop.model.ProductInfoModel;

public class TestProductService {

	IProductInfoService productInfoService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		productInfoService = (IProductInfoService) ctx.getBean("productInfoService");
	}
	
	@Test
	public void testInsert(){
		UserBuyer user = new UserBuyer();
		user.setName("jack");
		user.setRealname("Tom");
		for(int i=1; i<101 ; i++){
			ProductInfoModel p = new ProductInfoModel();
			p.setName("我是矿泉水"+i);
			p.setImageBig("images/t"+i%5+".jpg");
			p.setRemainNumber(i);
			p.setPrice(i);
			p.setCounter(i);
			p.setProductid("1234"+i);
			p.setKeyword("矿泉水"+i);
			p.setDescription("矿泉水");
			productInfoService.insertEntity(p, user);
		}
	}
	
	@Test
	public void testFindAllList(){
		UserBuyer user = new UserBuyer();
		user.setName("jack");
		user.setRealname("Tom");
		List<ProductInfoModel> lists = productInfoService.findEntityList();
		for(int i=0; i<lists.size(); i++){
			productInfoService.deleteEntity(lists.get(i), user);
		}
	}

}
