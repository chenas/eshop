package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.eshop.filter.ProductInfoFilter;
import com.eshop.model.ProductInfoModel;
import com.eshop.service.IProductInfoService;


@Component
public class ProductInfoListAction extends EntityListAction<ProductInfoModel> {
	
	@Resource
	private IProductInfoService productInfoService;

	@Resource
	private ProductInfoFilter productInfoFilter;

	//搜索关键词
	private String keyword;
	
	@Override
	protected void commonOperations() throws Exception {
		productInfoFilter.setQueryString(" where a.name like '"+keyword+"' or a.keyword like '"+keyword+"'");
	}
	
	//搜索商品
	public String searchProduct(){
		productInfoFilter.setKeyword(keyword);
		productInfoFilter.setName(keyword);
		productInfoFilter.setQueryString(" where a.name like '%"+keyword+"%' or a.keyword like '%"+keyword+"%'");
		productInfoFilter.setOrderByString(" counter desc");
		return intoList();
	}
	
	//展示所有商品
	public String allProduct(){
		return intoList();
	}
	
	//展示商品，根据分类列表的值展示商品
	public String showProduct(){
		productInfoFilter.setOrderByString(" counter desc");
		return intoList();
	}
	
	public IProductInfoService getProductInfoService() {
		return productInfoService;
	}

	public void setProductInfoService(IProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}

	public ProductInfoFilter getProductInfoFilter() {
		return productInfoFilter;
	}

	public void setProductInfoFilter(ProductInfoFilter productInfoFilter) {
		this.productInfoFilter = productInfoFilter;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
