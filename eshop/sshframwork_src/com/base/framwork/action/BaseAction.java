package com.base.framwork.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.base.framwork.Constants;
import com.base.framwork.domain.IUser;
import com.base.framwork.service.IUtilService;
import com.base.framwork.util.SpringBeanUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 所有Action的基类
 * @author chenas
 *
 */
public class BaseAction extends ActionSupport implements SessionAware,
ServletRequestAware, ParameterAware, ServletResponseAware {


	/**
	 * HTTP request请求对象
	 */
	private HttpServletRequest request;

	/**
	 * HTTP 响应头
	 */
	private HttpServletResponse response;

	/**
	 * session a Map of HTTP session attribute name/value pairs
	 */
	private Map<String, Object> session = null;

	/**
	 * parameters a Map of parameters (name/value Strings).
	 */
	private Map<String, String[]> parameters = null;
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	protected Map<String, Object> getSession(){
		return this.session;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Map<String, String[]> getParameters() {
		return parameters;
	}
	
	@Resource
	private IUtilService utilService;
	

	/**
	 * 取得当前session中的登陆用户
	 * 
	 * @return 登陆用户
	 */
	public IUser getLoginUser() {
		IUser user = (IUser) doGetSessionObject(Constants.CURRENT_USER_KEY);
		return user;
	}

	/**
	 * 将参数value放到以key为主键的session中
	 * 
	 * @param key
	 *            主键
	 * @param value
	 *            参数
	 */
	public void doPutSessionObject(String key, Object value) {
		this.getSession().put(key, value);
	}

	/**
	 * 获得sesion对象
	 * 
	 * @param key
	 *            键
	 * @return session的值
	 */
	public Object doGetSessionObject(String key) {
		return getSession().get(key);
	}
	
	/**
	 * 根据spring bean id获取spring bean
	 */
	public Object getService(String serviceBeanId) {
		return SpringBeanUtil.getSpringService(serviceBeanId);
	}
	
}
