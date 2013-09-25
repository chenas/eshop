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
	
	protected int pageNo=1;
	
	protected int pageSize=16;
	
	public String execute() throws Exception {
		commonOperations();	
		return intoList();
	}
	
	/**
	 * 进入列表
	 * @return
	 */
	public String intoList(){
//		getEntityFilter().setPageNo(pageNo);
		pageList.setFullListSize(querySize(getEntityFilter()));
		pageList.setPageNumber(getEntityFilter().getPageNo());
		pageList.setObjectsPerPage(getEntityFilter().getPageSize());
		pageList.setList(query(getEntityFilter()));
		ServletActionContext.getContext().put("pageList", pageList);
		return "list";
	}
	
	/**
	 * 查询记录,子类可重写此方法
	 * @param filter
	 * @return
	 * 				List<T>
	 */
	public List<T> query(QueryFilter filter){
		return getEntityService().findEntityListByFilter(filter);
	}
	
	/**
	 * 统计记录数目，与query配合使用
	 * @param filter
	 * @return
	 * 				int
	 */
	public int querySize(QueryFilter filter){
		return getEntityService().countEntityByFilter(filter);
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
