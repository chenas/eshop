package com.base.framwork.queryfilter;

import java.util.Map;

/**
 * 查询条件过滤类
 * @author chenas
 * 2013年08月11日
 */

public class QueryFilter{
	
	/**
	 * 是否分页
	 * 默认为true，表示分页
	 */
	private boolean isLimited = true;
	
	/**
	 * 表示第几页
	 */
	private int pageNo = 1;
	
	/**
	 * 每页的记录数
	 * 默认一页显示10条
	 */
	private int pageSize = 10;
	
	/**
	 * 根据此字符串排序
	 */
	private String orderByString;
	
	/**
	 * 查询语句(结尾加上空格)
	 * 	where +
	 * 	between
	 */
	private String queryString;
	
	/**
	 * 过滤条件
	 * String:
	 * 		对应数据库中的列名
	 * Object：
	 * 		各种数据类型的值
	 * 
	 */
	
	private Map<String, Object> mapCondition;

	public boolean isLimited() {
		return isLimited;
	}

	public void setLimited(boolean isLimited) {
		this.isLimited = isLimited;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderByString() {
		return orderByString;
	}

	public void setOrderByString(String orderByString) {
		this.orderByString = orderByString;
	}

	public Map<String, Object> getMapCondition() {
		return mapCondition;
	}

	public void setMapCondition(Map<String, Object> mapCondition) {
		this.mapCondition = mapCondition;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	
}
