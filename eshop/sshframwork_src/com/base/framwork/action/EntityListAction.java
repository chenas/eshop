package com.base.framwork.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.base.framwork.domain.BaseModel;
import com.base.framwork.domain.PageList;
import com.base.framwork.queryfilter.QueryFilter;
import com.base.framwork.util.ReflectUtil;
/**
 * 列表action
 * @author chenas
 *
 * @param <T>
 */
public class EntityListAction<T extends BaseModel> extends EntityBaseAction<T> {
	
	//
	@Resource
	protected PageList pageList;
	
	protected int pageNo;
	
	protected int pageSize;
	
	public String execute() throws Exception {
		commonOperations();		
		return intoList();
	}
	
	public String intoList(){
		getEntityFilter().setPageNo(pageNo);
		pageList.setFullListSize(getEntityService().countEntityByFilter(getEntityFilter()));
		pageList.setPageNumber(pageNo);
		pageList.setObjectsPerPage(pageSize);
		pageList.setList(query(getEntityFilter()));
		ServletActionContext.getContext().put("pageList", pageList);
		return "list";
	}
	
	/**
	 * 
	 * @param filter
	 * @return
	 */
	public List<T> query(QueryFilter filter){
		return getEntityService().findEntityListByFilter(filter);
	}
	
	public PageList getPageList() {
		return pageList;
	}

	public void setPageList(PageList pageList) {
		this.pageList = pageList;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
