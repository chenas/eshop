package com.base.framwork.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * 实现IBaseDao类
 * @author chenas
 *2013年08月11日
 */
public class BaseDao implements IBaseDao{

	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
}
