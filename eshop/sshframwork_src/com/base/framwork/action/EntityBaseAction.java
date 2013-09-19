package com.base.framwork.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import com.base.framwork.domain.BaseModel;
import com.base.framwork.service.IEntityService;
import com.base.framwork.util.ReflectUtil;
import com.base.framwork.util.SpringBeanUtil;


/**
 * 实体类action
 * @author chenas
 *
 * @param <T>
 */
public class EntityBaseAction<T extends BaseModel> extends BaseAction {
	
	//action
	private String id;
	
	/**
	 * domain
	 */
	protected String modelName = null;

	/**
	 * 由BeanID获得Service
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public IEntityService<T> getEntityService() {
		//5为model的长度
		String serviceName = getModelName().substring(0, getModelName().length()-5)+"Service";
		String beanId = serviceName.substring(0, 1).toLowerCase()+serviceName.substring(1);
		return (IEntityService<T>) SpringBeanUtil.getSpringService(beanId);
	}

	/**
	 * 
	 * 
	 * @throws Exception
	 *             
	 */
	protected void commonOperations() throws Exception {
	}

	/**
	 * 
	 * 
	 * @param paramString
	 *           
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

	/**
	 * ModelName
	 * @return
	 */
	public String getModelName() {
		String actionName = this.getClass().getSimpleName();
		String suffix = "Action";
		if(this instanceof EntityListAction<?>){
			suffix = "ListAction";
		}
		return actionName.substring(0, actionName.length()-suffix.length())+"Model";
	}

	public void setModelName(String domainName) {
		this.modelName = domainName;
	}

}
