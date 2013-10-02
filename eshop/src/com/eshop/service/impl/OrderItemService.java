package com.eshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.base.framwork.service.EntityService;
import com.eshop.filter.OrderItemFilter;
import com.eshop.model.OrderItemModel;
import com.eshop.service.IOrderItemService;
/**
 * 
 * @author tianziwang
 *
 */
@Component
public class OrderItemService extends EntityService<OrderItemModel> implements IOrderItemService{

	/**
	 * 从数据库获取购物车内容
	 * @param userId
	 * 					登录用户ID
	 * @return
	 * 					PageList
	 */
	public List findOrderItemByUserId(String userId){
		OrderItemFilter ItemFilter = new OrderItemFilter();
		List<OrderItemModel> itemList = new ArrayList<OrderItemModel>();
		ItemFilter.setQueryString(" where a.buyer_id='"+userId+"' and a.is_finished='1'");
		List<OrderItemModel> items = findEntityListByFilter(ItemFilter);
		if(null != items && items.size()>0){
			itemList.addAll(items);
			return itemList;
		}
		return null;
	}
}
