package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.eshop.filter.OrderitemFilter;
import com.eshop.model.OrderItemModel;
import com.eshop.service.IOrderItemService;

@Component
public class OrderItemListAction extends EntityListAction<OrderItemModel> {
	
	@Resource
	private IOrderItemService orderitemService;

	private OrderitemFilter orderitemFilter;

	public IOrderItemService getOrderitemService() {
		return orderitemService;
	}

	public void setOrderitemService(IOrderItemService orderitemService) {
		this.orderitemService = orderitemService;
	}

	public OrderitemFilter getOrderitemFilter() {
		return orderitemFilter;
	}

	public void setOrderitemFilter(OrderitemFilter orderitemFilter) {
		this.orderitemFilter = orderitemFilter;
	}

}
