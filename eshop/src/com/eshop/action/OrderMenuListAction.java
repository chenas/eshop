package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.eshop.filter.OrderMenuFilter;
import com.eshop.model.OrderMenuModel;
import com.eshop.service.IOrderMenuService;

@Component
public class OrderMenuListAction extends EntityListAction<OrderMenuModel> {

	@Resource
	private IOrderMenuService orderMenuService;

	private OrderMenuFilter orderMenuFilter;

	public String listOrder(){
		
		return SUCCESS;
	}
	
	public IOrderMenuService getOrderMenuService() {
		return orderMenuService;
	}

	public void setOrderMenuService(IOrderMenuService orderMenuService) {
		this.orderMenuService = orderMenuService;
	}

	public OrderMenuFilter getOrderMenuFilter() {
		return orderMenuFilter;
	}

	public void setOrderMenuFilter(OrderMenuFilter orderMenuFilter) {
		this.orderMenuFilter = orderMenuFilter;
	}

}
