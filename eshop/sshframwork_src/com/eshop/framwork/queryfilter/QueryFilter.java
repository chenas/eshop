package com.eshop.framwork.queryfilter;

import java.util.List;
import java.util.Map;

/**
 * 查询条件过滤类
 * @author chenas
 * 2013年08月11日
 */

public class QueryFilter implements IFilter{
	
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
	 * 过滤条件
	 */
	private List<IFilter> lstCondition;

	@Override
	public int getPageNo() {
		return pageNo;
	}

	@Override
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

	@Override
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String getOrderByString() {
		return orderByString;
	}

	@Override
	public void setOrderByString(String orderByString) {
		this.orderByString = orderByString;
	}

	@Override
	public List<IFilter> getLstCondition() {
		return lstCondition;
	}

	@Override
	public void setLstCondition(List<IFilter> lstCondition) {
		this.lstCondition = lstCondition;
	}

	@Override
	public void setColunmName(String colunmName) {
		
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public void setValue(String value) {
		
	}

	@Override
	public String getValueType() {
		return null;
	}

	@Override
	public void setValueType(String valueType) {
		
	}

	@Override
	public boolean isLimited() {
		return isLimited;
	}

	@Override
	public void setLimited(boolean isLimited) {
		this.isLimited = isLimited;
	}

	@Override
	public String getColunmName() {
		return null;
	}

}
