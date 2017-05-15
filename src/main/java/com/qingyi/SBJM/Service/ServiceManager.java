package com.qingyi.SBJM.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service管理类(需要管理的Service放入其中)
 *
 * @author qingyi xuelongqy@foxmail.com
 * @Title: ServiceManager类
 * @Description: Service管理类
 * @version: V1.0
 * @date 2017 -01-17 20:58:15
 */
@Component
public class ServiceManager {
	
	@Autowired
	protected UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
