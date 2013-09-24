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
