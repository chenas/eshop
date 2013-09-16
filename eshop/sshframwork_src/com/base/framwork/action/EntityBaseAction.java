package com.base.framwork.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.base.framwork.Constants;
import com.base.framwork.domain.BaseModel;
import com.base.framwork.service.EntityService;


/**
 * 实体类action
 * @author chenas
 *
 * @param <T>
 */
public class EntityBaseAction<T extends BaseModel> extends BaseAction {
	
	//action���ô��ݵ�����
	private String id;
	
	@Resource
	protected EntityService<T> entityService;


	/**
	 * domain�����
	 */
	protected String domainName = null;

	/**
	 * ���action��Domain+Action/Domain+ListAction/Domain+JsonListAction����ķ�ʽ�������Զ�ע�룬
	 * ����������д�÷���������entityService
	 * 
	 * @param entityService
	 */
/*	@SuppressWarnings("unchecked")
	public void setEntityService(EntityService<T> entityService) {
		String suffix = "Action";
		if (this instanceof EntityListAction<?>) {
			suffix = "ListAction";
		} else if (this instanceof EntityJsonListAction<?>) {
			suffix = "JsonListAction";
		}
		String className = this.getClass().getSimpleName();
		if (className.endsWith(suffix)) {
			domainName = className.substring(0, className.length()
					- suffix.length());
		} else {
			System.out.println("Action class name's format must be \"DomainName\" + \""
							+ suffix
							+ "\", "
							+ "or you can overwrite the method setEntityService in your Action!");
			domainName = "";
		}
		// ��һ���ַ�ĳ�Сд
		domainName = domainName.substring(0, 1).toLowerCase()
				+ domainName.substring(1);
		this.entityService = (EntityService<T>) getService(domainName
				+ "Service");
	}*/

	/**
	 * ��ͨ������ͨ������У��
	 * 
	 * @throws Exception
	 *             �׳����쳣
	 */
	protected void commonOperations() throws Exception {
	}

	/**
	 * ������ʾ��Ϣ
	 * 
	 * @param paramString
	 *            ��ʾ��Ϣ
	 */
	protected void saveMessage(String paramString) {
		String str = getText(paramString);
		//getRequest().getSession().setAttribute(Constants.POP_MESSAGE_KEY, str);
	}
	/**
	 * ���ǰ̨�ύ��id
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * ����ǰ̨�ύ��id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ���ǰ̨�ύ�Ķ��id
	 * @return id����
	 */
	public String[] getIds() {
		if (StringUtils.isNotEmpty(id)) {
			return id.split(", ");// 
		} else {
			return new String[0];
		}
	}

}
