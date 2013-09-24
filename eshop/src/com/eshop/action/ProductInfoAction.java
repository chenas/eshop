package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.ProductInfoFilter;
import com.eshop.model.ProductInfoModel;
import com.eshop.service.IProductInfoService;


/**
 * 商品信息action
 * @author chenas
 *
 */
@Component
public class ProductInfoAction extends EntityCrudAction<ProductInfoModel> {
	
	@Resource
	private IProductInfoService productInfoService;
	
	private ProductInfoModel productInfoModel;
	
	private ProductInfoFilter productInfoFilter;

	public IProductInfoService getProductInfoService() {
		return productInfoService;
	}

	public void setProductInfoService(IProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}

	public ProductInfoModel getProductInfoModel() {
		return productInfoModel;
	}

	public void setProductInfoModel(ProductInfoModel productInfoModel) {
		this.productInfoModel = productInfoModel;
	}

	public ProductInfoFilter getProductInfoFilter() {
		return productInfoFilter;
	}

	public void setProductInfoFilter(ProductInfoFilter productInfoFilter) {
		this.productInfoFilter = productInfoFilter;
	}

}
