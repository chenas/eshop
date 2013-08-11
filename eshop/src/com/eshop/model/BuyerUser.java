package com.eshop.model;

import javax.persistence.Entity;

import com.eshop.framwork.domain.BaseModel;

@Entity(name="BUYER_USER")
public class BuyerUser extends BaseModel{

	private String username;
	private String password;
	private long addrId;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getAddrId() {
		return addrId;
	}
	public void setAddrId(long addrId) {
		this.addrId = addrId;
	}
	
}
