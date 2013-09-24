package com.eshop.commonsys.action;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.eshop.filter.ProductInfoFilter;
import com.eshop.model.ProductInfoModel;

/**
 * 商品搜索
 * @author chenas
 *
 */
@Component
public class SearchProductAction extends EntityListAction<ProductInfoModel>{
	
	private String keyword;
	
	private ProductInfoFilter productInfoFilter;

	@Override
	protected void commonOperations() throws Exception {
		getEntityFilter().setQueryString(" where a.name like '"+keyword+"' or a.keyword like '"+keyword+"'");
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public ProductInfoFilter getProductInfoFilter() {
		return productInfoFilter;
	}

	public void setProductInfoFilter(ProductInfoFilter productInfoFilter) {
		this.productInfoFilter = productInfoFilter;
	}
	
}
