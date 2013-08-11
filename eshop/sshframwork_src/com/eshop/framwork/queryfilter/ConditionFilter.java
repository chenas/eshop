package com.eshop.framwork.queryfilter;

import java.util.List;

/**
 * 条件过滤类
 * 存放数据库表中的字段名，与其对应的值与值类型
 * @author chenas
 * 2013年08月11日
 */

public class ConditionFilter implements IFilter{
	
	/**
	 * 列名
	 */
	private String colunmName;
	
	/**
	 * 值
	 */
	private String value;
	
	/**
	 * 值类型
	 */
	private String valueType;

	@Override
	public String getColunmName() {
		return colunmName;
	}

	@Override
	public void setColunmName(String colunmName) {
		this.colunmName = colunmName;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getValueType() {
		return valueType;
	}

	@Override
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	@Override
	public int getPageNo() {
		return 0;
	}

	@Override
	public void setPageNo(int pageNo) {
		
	}

	@Override
	public int getPageSize() {
		return 0;
	}

	@Override
	public void setPageSize(int pageSize) {
		
	}

	@Override
	public String getOrderByString() {
		return null;
	}

	@Override
	public void setOrderByString(String orderByString) {
		
	}

	@Override
	public List<IFilter> getLstCondition() {
		return null;
	}

	@Override
	public void setLstCondition(List<IFilter> lstCondition) {
		
	}

	@Override
	public boolean isLimited() {
		return true;
	}

	@Override
	public void setLimited(boolean isLimited) {
		
	}
	
}
