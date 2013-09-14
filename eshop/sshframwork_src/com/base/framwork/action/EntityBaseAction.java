package com.base.framwork.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.base.framwork.domain.BaseModel;
import com.base.framwork.service.EntityService;


/**
 * 所有实体类action的基类
 * @author chenas
 *
 * @param <T>
 */
public class EntityBaseAction<T extends BaseModel> extends BaseAction {
	
	//action调用传递的主键
	private String id;
	
	@Resource
	protected EntityService<T> entityService;

	/**
	 * 共通方法，通常用来校验
	 * 
	 * @throws Exception
	 *             抛出的异常
	 */
	protected void commonOperations() throws Exception {
	}

	/**
	 * 保存提示信息
	 * 
	 * @param paramString
	 *            提示信息
	 */
	protected void saveMessage(String paramString) {
		//String str = MessageUtils.getMessage(paramString);
		String str = getText(paramString);//修改by suntao 以适应国际化要求
		//getRequest().getSession().setAttribute(Constants.POP_MESSAGE_KEY, str);
	}
	/**
	 * 获得前台提交的id
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置前台提交的id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获得前台提交的多个id
	 * @return id组数
	 */
	public String[] getIds() {
		if (StringUtils.isNotEmpty(id)) {
			return id.split(", ");// struts2多提交是逗号加空格隔开的
		} else {
			return new String[0];
		}
	}

}
