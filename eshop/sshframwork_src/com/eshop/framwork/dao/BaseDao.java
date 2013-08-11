package com.eshop.framwork.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * 实现IBaseDao类
 * @author chenas
 *2013年08月11日
 */

public class BaseDao implements IBaseDao{

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
