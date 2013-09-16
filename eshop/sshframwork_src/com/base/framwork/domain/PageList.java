package com.base.framwork.domain;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
/** ���ڷ�װ��ǰ��ҳ��ݵ�PaginatedListʵ���� */
@Component
public class PageList{
	@SuppressWarnings("rawtypes")
	private List list;//ÿҳ���б�
    private Map<?, ?> map; //ÿҳ���б�
    private int pageNumber=1;//��ǰҳ��
    private int objectsPerPage=15;//ÿҳ��¼��
    private int fullListSize = 0;//�ܼ�¼��
    private int totalPage = 0;  //һ���ж���ҳ
    
    private String sortCriterion;
    private String searchId;
    
	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}
	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getObjectsPerPage() {
		return objectsPerPage;
	}
	public void setObjectsPerPage(int objectsPerPage) {
		this.objectsPerPage = objectsPerPage;
	}
	public int getFullListSize() {
		return fullListSize;
	}
	public void setFullListSize(int fullListSize) {
		this.fullListSize = fullListSize;
	}
	public String getSortCriterion() {
		return sortCriterion;
	}
	public void setSortCriterion(String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}
	public String getSearchId() {
		return searchId;
	}
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
	public Map<?, ?> getMap() {
		return map;
	}
	public void setMap(Map<?, ?> map) {
		this.map = map;
	}
	public int getTotalPage() {
		if(fullListSize % objectsPerPage == 0)
		{
			this.totalPage = fullListSize / objectsPerPage;
		}
		else{
			this.totalPage = fullListSize / objectsPerPage + 1;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
