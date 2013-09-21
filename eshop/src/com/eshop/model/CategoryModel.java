package com.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
/**
 * 一级分类
 * @author Administrator
 *
 */
@Entity(name="CATEGORY")
public class CategoryModel {
	
private String name;

private String describe;

@Column(name="name", length=20,nullable=false)
public String getName() {
	return name;
}
@Column(name="describe", length=100)
public String getDescribe() {
	return describe;
}
public void setName(String name) {
	this.name = name;
}
public void setDescribe(String describe) {
	this.describe = describe;
}


}
