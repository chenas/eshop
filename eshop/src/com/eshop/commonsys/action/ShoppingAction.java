package com.eshop.commonsys.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.base.framwork.action.BaseAction;
import com.base.framwork.service.IUtilService;
import com.eshop.domain.CartList;
import com.eshop.domain.OrderMenu;
import com.eshop.domain.UserBuyer;
import com.eshop.model.BuyerAddrModel;
import com.eshop.model.OrderItemModel;
import com.eshop.model.ProductInfoModel;
import com.eshop.service.IBuyerAddrService;
import com.eshop.service.IOrderMenuService;
import com.eshop.service.IProductInfoService;
import com.eshop.service.IUserBuyerService;
import com.eshop.util.GetOrderIdUtil;

@Component
public class ShoppingAction extends BaseAction {

	@Resource
	private IBuyerAddrService buyerAddrService;
	
	@Resource
	private IOrderMenuService orderMenuService;
	
	@Resource
	private IProductInfoService productInfoService;
	
	@Resource
	private IUserBuyerService userBuyerService;
	
	@Resource
	private IUtilService utilService;

	//校区
	private String schoolArea;
	
	//具体的地址
	private String building;
	
	//收货人
	private String consignee;
	
	//联系方式
	private String phone;
	
	//备注，更具体的地址、送货时间
	private String address;

	public String sumitOrder(){
		UserBuyer user = (UserBuyer) doGetSessionObject("loginUser");
		ProductInfoModel productInfoModel = null;
		CartList cartList = (CartList) doGetSessionObject("cartList");
		if(cartList == null){
			return INPUT;
		}
		
		List<OrderItemModel> orderItemModels = cartList.getItems();
		synchronized (orderItemModels) {
			for(OrderItemModel orderItemModel : orderItemModels){
				productInfoModel = productInfoService.findEntityById(orderItemModel.getProductId());
				if(productInfoModel.getRemainNumber() < orderItemModel.getCount())
				{
					addActionMessage("抱歉，"+productInfoModel.getName()+"库存量不足");
					return INPUT;
				}
			}
			for(OrderItemModel orderItemModel : orderItemModels){
				productInfoModel = productInfoService.findEntityById(orderItemModel.getProductId());
				productInfoModel.setRemainNumber(productInfoModel.getRemainNumber() - orderItemModel.getCount());
				productInfoService.updateEntity(productInfoModel, user);
			}
		}

		OrderMenu orderMenu = new OrderMenu();
		BuyerAddrModel buyerAddr = new BuyerAddrModel();
		buyerAddr.setSchoolArea(schoolArea);
		buyerAddr.setBuilding(building);
		buyerAddr.setConsignee(consignee);
		buyerAddr.setPhone(phone);
		buyerAddr.setAddress(address);
		//设置为默认地址
		buyerAddr.setIsDefault("1");
		String buyerAddrId = "";
		if(user != null){
			orderMenu.setBuyerId(user.getId());
			buyerAddr.setBuyerId(user.getId());
			buyerAddrId = buyerAddrService.insertEntity(buyerAddr, user);
		}else{
			buyerAddrId = buyerAddrService.insertEntity(buyerAddr, null);
		}

		//下单时间
		orderMenu.setOrderdate(utilService.getSystemDateTimeString());
		//订单编号
		orderMenu.setOrderid(GetOrderIdUtil.nextCode());
		orderMenu.setTotalpris(cartList.getTotalPrice());
		orderMenu.setStatus("o");
		orderMenu.setShopId(productInfoModel.getShopId());
		orderMenu.setAddrId(buyerAddrId);
		
		orderMenuService.insertEntity(orderMenu, user);
		ServletActionContext.getContext().put("orderId", orderMenu.getOrderid());
		ServletActionContext.getContext().put("address", schoolArea+"  "+building+" "+address);
		getSession().remove("cartList");
		return SUCCESS;
	}
	
	
	public String getSchoolArea() {
		return schoolArea;
	}

	public void setSchoolArea(String schoolArea) {
		this.schoolArea = schoolArea;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
