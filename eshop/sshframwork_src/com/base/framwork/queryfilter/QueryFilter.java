package com.base.framwork.queryfilter;

import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * ��ѯ����������
 * @author chenas
 * 2013��08��11��
 */
public class QueryFilter{
	
	/**
	 * �Ƿ��ҳ
	 * Ĭ��Ϊtrue����ʾ��ҳ
	 */
	private boolean isLimited = true;
	
	/**
	 * ��ʾ�ڼ�ҳ
	 */
	private int pageNo = 1;
	
	/**
	 * ÿҳ�ļ�¼��
	 * Ĭ��һҳ��ʾ10��
	 */
	private int pageSize = 10;
	
	/**
	 * ��ݴ��ַ�����
	 */
	private String orderByString;
	
	/**
	 * ��ѯ���(��β���Ͽո�)
	 * 	where +
	 * 	between
	 */
	private String queryString;
	
	/**
	 * ��������
	 * String:
	 * 		��Ӧ��ݿ��е�����
	 * Object��
	 * 		����������͵�ֵ
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
