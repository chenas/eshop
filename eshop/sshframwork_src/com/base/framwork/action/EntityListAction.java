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
	

	/**
	 * Domain+filter
	 * 获得实体的查询条件（列表页面简单查询）
	 * @return 查询条件
	 */
	private QueryFilter getEntityFilter(){
		QueryFilter filter = null;
		try{
//			filter = (QueryFilter)MethodUtils.invokeMethod(this, ReflectUtil.getGetterOfField("filter"), null);
			if(filter == null){
				Class<?> type = Class.forName(getFilterPackage() + "." + ReflectUtil.firstUpperCase(getModelName().substring(0, getModelName().indexOf("Model")) + "Filter"));
				filter = (QueryFilter)type.newInstance();
			}
		}catch (Exception e) {
			System.out.println("Reflect error, when get entity filter of "+ getClass().getName()+ ".");
		}
		return filter;
	}
	
	/**
	 * 设置实体的查询条件
	 * @param filter 查询条件
	 */
	private void setEntityFilter(QueryFilter filter){
		try{
			MethodUtils.invokeMethod(this, ReflectUtil.getSetterOfField("filter"), filter);
		}catch (Exception e) {
			System.out.println("Reflect error, when set entity filter of "+ getClass().getName()+ ".");
		}
	}

	/**
	 * 获得翻页条件类所在的包的名称
	 * @return 翻页条件类所在的包的名称
	 */
	public String getFilterPackage(){
		return "com.eshop.filter";
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
