package com.eshop.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.eshop.model.OrderItemModel;
import com.eshop.util.DoubleUtil;

/**
 * 购物车
 * @author chenas
 *
 */
public class CartList {
	private double totalPrice;
	List<OrderItemModel> items = new ArrayList<OrderItemModel>();

	/**
	 * 将商品加入购物车
	 * @param OrderItemModel
	 */
	public void addOrderItem(OrderItemModel ci) {
		if (items.size() > 0) {
			for (Iterator<OrderItemModel> iter = items.iterator(); iter.hasNext();) {
				OrderItemModel item = iter.next();
				if (item.getProductId().equals(ci.getProductId())) {
					iter.remove();
					break;
				}
			}
		}
		items.add(ci);
	}

	/**
	 * 从购物车中移除商品
	 * @param productId
	 */
	public void deleteItemById(String productId) {
		for (Iterator<OrderItemModel> iter = items.iterator(); iter.hasNext();) {
			OrderItemModel item = iter.next();
			if (item.getProductId().equals(productId)) {
				iter.remove();
			}
		}
	}
	
	/**
	 * 增加商品购买数目
	 * @param productId
	 * 					product主键
	 * @param num
	 * 					增加量
	 */
	public void addNum(String productId, int num){
		if (items.size() > 0 && items != null) {
			for (Iterator<OrderItemModel> iter = items.iterator(); iter.hasNext();) {
				OrderItemModel item = iter.next();
				if (item.getProductId().equals(productId)) {
					//if(item.getIsRemain().equals("1")){
						item.setCount(item.getCount() + num);
						item.setItempris(DoubleUtil.add(item.getItempris(), DoubleUtil.mul(item.getPrice(), num)));
				//	}
				}
			}
		}
	}
	
	/**
	 * 减少商品购买数目
	 * @param productId
	 * 					product主键
	 * @param num
	 * 					减少量
	 */
	public void decreasNum(String productId, int num){
		if (items.size() > 0 && items != null) {
			for (Iterator<OrderItemModel> iter = items.iterator(); iter.hasNext();) {
				OrderItemModel item = iter.next();
				if (item.getProductId().equals(productId)) {
					if(item.getCount() >= num){
						item.setCount(item.getCount() - num);
						item.setItempris(DoubleUtil.sub(item.getItempris(), DoubleUtil.mul(item.getPrice(), num)));
					}
				}
			}
		}
	}
	//
	public OrderItemModel getItemById(String productId){
		if (items.size() > 0 && items != null) {
			for (Iterator<OrderItemModel> iter = items.iterator(); iter.hasNext();) {
				OrderItemModel item = iter.next();
				if (item.getProductId().equals(productId)) {
					return item;
				}
			}
		}
		return null;
	}


	/**
	 * 得到购物车总价格
	 * @return
	 */
	public double getTotalPrice() {
		totalPrice = 0.0;
		for (Iterator<OrderItemModel> it = items.iterator(); it.hasNext();) {
			OrderItemModel current = it.next();
			totalPrice = DoubleUtil.add(totalPrice, current.getItempris());
		}
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderItemModel> getItems() {
		return items;
	}

	public void setItems(List<OrderItemModel> items) {
		this.items = items;
	}
}
