package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.OrderitemFilter;
import com.eshop.model.OrderItemModel;
import com.eshop.service.IOrderItemService;

@Component
public class OrderitemAction extends EntityCrudAction<OrderItemModel> {
	
	@Resource
	private IOrderItemService orderitemService;
	
	private OrderItemModel orderitemModel;
	
	private OrderitemFilter orderitemFilter;

	public IOrderItemService getOrderitemService() {
		return orderitemService;
	}

	public void setOrderitemService(IOrderItemService orderitemService) {
		this.orderitemService = orderitemService;
	}

	public OrderItemModel getOrderitemModel() {
		return orderitemModel;
	}

	public void setOrderitemModel(OrderItemModel orderitemModel) {
		this.orderitemModel = orderitemModel;
	}

	public OrderitemFilter getOrderitemFilter() {
		return orderitemFilter;
	}

	public void setOrderitemFilter(OrderitemFilter orderitemFilter) {
		this.orderitemFilter = orderitemFilter;
	}

}
