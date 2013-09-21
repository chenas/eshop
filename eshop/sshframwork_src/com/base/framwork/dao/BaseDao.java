package com.base.framwork.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * 所有dao的基类
 * @author chenas
 *2013��08��11��
 */
public class BaseDao implements IBaseDao{

	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
}
