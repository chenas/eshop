package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.eshop.filter.ProductViewFilter;
import com.eshop.service.IProductViewService;
import com.eshop.view.ProductViewModel;

@Component
public class ProductViewListAction extends EntityListAction<ProductViewModel> {

	@Resource
	private IProductViewService productViewService;
	
	//搜索关键词，分类名
	private String keyword;
	
	private ProductViewFilter productViewFilter;
	
	//搜索商品
	public String searchProduct(){ 
		ProductViewFilter productFilter = new ProductViewFilter();
		productFilter.setQueryString(" where a.name like '%"+keyword+"%' or a.keyword like '%"+keyword+"%'");
		productFilter.setOrderByString(" counter desc");
		pageList.setList(query(productFilter));
		pageList.setFullListSize(querySize(productFilter));
		return LIST;
	}
	
	//展示所有商品
	public String allProduct(){
		return intoList();
	}
	
	//展示商品，根据分类列表的值展示商品
	public String showProduct(){
		ProductViewFilter productFilter = new ProductViewFilter();
		productFilter.setQueryString(" where a.categoryName like '%"+keyword+"%' or a.cateDetailName like '%"+keyword+"%'");
		productFilter.setOrderByString(" counter desc");
		pageList.setList(query(productFilter));
		pageList.setFullListSize(querySize(productFilter));
		return LIST;
	}

	public ProductViewFilter getProductViewFilter() {
		return productViewFilter;
	}

	public void setProductViewFilter(ProductViewFilter productViewFilter) {
		this.productViewFilter = productViewFilter;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
