package com.eshop.service.ajax;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.service.mail.IMailSenderService;
import com.eshop.service.IUserBuyerService;

/**
 * 验证用户信息 ajax
 * 
 * @author chenas
 * 
 */
@Component
public class UserBuyerServiceAjax {

	@Resource
	private IUserBuyerService userBuyerService;
	
	@Resource
	private IMailSenderService mailSenderService;

	/**
	 * 用户名是否已经被注册
	 * 
	 * @param name
	 * @return true if has
	 */
	public boolean hasUser(String name) {
		if(name == null || "".equals(name)){
			return false;
		}
		if (userBuyerService.hasUser(name, null) != null) {
			return true;
		} else
			return false;
	}

	/**
	 * 此邮箱是否已被注册
	 * 
	 * @param Email
	 * @return true if has
	 */
	public boolean hasEmail(String Email) {
		if(null == Email || "".equals(Email)){
			return false;
		}
		if (userBuyerService.hasEmail(Email)) {
			return true;
		} else
			return false;
	}
	
	/**
	 * 检查邮箱是否真实存在
	 * @param Email
	 * @return
	 * 		true if exist
	 */
	public boolean existEmail(String Email){
		if(null == Email || "".equals(Email)){
			return false;
		}
		if(mailSenderService.checkEmail(Email)){
			return true;
		}else
			return false;
	}
}
