package com.eshop.framwork.queryfilter;

import java.util.List;

/**
 * 查询过滤器统一接口
 * @author chenas
 *
 */
public interface IFilter {
	
	public boolean isLimited();

	public void setLimited(boolean isLimited);

	public int getPageNo();

	public void setPageNo(int pageNo);

	public int getPageSize();

	public void setPageSize(int pageSize);

	public String getOrderByString();

	public void setOrderByString(String orderByString);

	public List<IFilter> getLstCondition();

	public void setLstCondition(List<IFilter> lstCondition);
	

	public String getColunmName();
	
	public void setColunmName(String colunmName);

	public String getValue();

	public void setValue(String value);

	public String getValueType();

	public void setValueType(String valueType);

}
