package com.eshop.service.ajax;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.eshop.service.IProductViewService;

/**
 * 前台交互
 * 商品加入购物车
 * 
 * @author chenas
 *
 */
@Component
public class ProductViewServiceAjax {
	
	@Resource
	private IProductViewService productViewService;
	
	/**
	 * 保存订单条目
	 * @param productId
	 * 						商品主键id
	 * @param buyNum
	 * 						购买数量
	 * @return
	 * 						success if saved
	 */
	public boolean saveOrderItem(String productId, int buyNum){
		System.out.println(productId + "  " +buyNum);
		return false;
	}

}
