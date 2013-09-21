package com.eshop.model;
import com.base.framwork.domain.BaseModel;
import javax.*;

import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *  @author supriseli
   email:supriseli007@gmail.com
 */
@Entity(name="BUYER_LEVEL")
public class BuyerLevelModel extends BaseModel{

	//等级名称
	private String name;
	//等级描述
	private String describe;
	//折扣
	private double discount;

	@Column(name="name", length=50,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="descbibe", length=100,nullable=true)
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Column(name="discount", length=10,nullable=true)
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}