package com.eshop.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.domain.UserBuyer;
import com.eshop.filter.CategoryDetailFilter;
import com.eshop.filter.CategoryFilter;
import com.eshop.filter.UserShopFilter;
import com.eshop.model.CategoryDetailModel;
import com.eshop.model.CategoryModel;
import com.eshop.model.ProductInfoModel;
import com.eshop.model.UserShopModel;

public class TestProductService {

	IProductInfoService productInfoService;

	ICategoryDetailService categoryDetailService;
	
	ICategoryService categoryService;
	
	IUserShopService userShopService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		productInfoService = (IProductInfoService) ctx.getBean("productInfoService");
		categoryDetailService = (ICategoryDetailService) ctx.getBean("categoryDetailService");
		categoryService = (ICategoryService) ctx.getBean("categoryService");
		userShopService = (IUserShopService) ctx.getBean("userShopService");
	}
	
	@Test
	public void testInsert(){
		UserBuyer user = new UserBuyer();
		user.setName("jack");
		user.setRealname("Tom");

		CategoryFilter cf = new CategoryFilter();
		cf.setQueryString(" where a.name='"+"美味的食品"+"'");
		CategoryModel c = categoryService.findEntityListByFilter(cf).get(0);
		
		CategoryDetailFilter cdf = new CategoryDetailFilter();
		cdf.setQueryString(" where a.name='"+"肉/豆制品"+"'");
		CategoryDetailModel cdm = categoryDetailService.findEntityListByFilter(cdf).get(0);
		
		UserShopFilter usf = new UserShopFilter();
		usf.setQueryString(" where a.name='"+"usst"+"'");
		UserShopModel us =  userShopService.findEntityListByFilter(usf).get(0);
		
		for(int i=1; i<50; i++){
			ProductInfoModel p = new ProductInfoModel();
			p.setName("H康康"+i);
			p.setImageBig("images/t"+i%5+".jpg");
			p.setRemainNumber(i);
			p.setPrice(i);
			p.setCounter(i);
			p.setProductid("1234"+i);
			p.setKeyword("不是康康康康"+i);
			p.setDescription("土豆片土豆片");
			p.setIsSale("1");
			p.setCategoryId(c.getId());
			p.setCategoryDetailId(cdm.getId());
			p.setShopId(us.getId());
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
