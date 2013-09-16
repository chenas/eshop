package com.base.framwork.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.base.framwork.domain.BaseModel;
import com.base.framwork.domain.PageList;
import com.base.framwork.queryfilter.QueryFilter;
/**
 * 列表action
 * @author chenas
 *
 * @param <T>
 */
@Component
public class EntityListAction<T extends BaseModel> extends EntityBaseAction<T> {
	
	private List<T> entityList;
	
	//���entity�����÷�ҳ
	@Resource
	protected PageList pageList;
	
	@Resource
	protected QueryFilter filter;
	
	protected int pageNo;
	
	protected int pageSize;
	
	public String execute() throws Exception {
		commonOperations();		
		return intoList();
	}
	
	public String intoList(){
		filter.setPageNo(pageNo);
		pageList.setFullListSize(entityService.countEntityByFilter(filter));
		pageList.setPageNumber(pageNo);
		pageList.setObjectsPerPage(pageSize);
		pageList.setList(query(filter));
		ServletActionContext.getContext().put("pageList", pageList);
		return "list";
	}
	
	/**
	 * Ĭ�ϲ�ѯ
	 * @param filter
	 * @return
	 */
	public List<T> query(QueryFilter filter){
		return this.entityService.findEntityListByFilter(filter);
	}

	public List<T> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<T> entityList) {
		this.entityList = entityList;
	}

	public PageList getPageList() {
		return pageList;
	}

	public void setPageList(PageList pageList) {
		this.pageList = pageList;
	}

	public QueryFilter getFilter() {
		return filter;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setFilter(QueryFilter filter) {
		this.filter = filter;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
