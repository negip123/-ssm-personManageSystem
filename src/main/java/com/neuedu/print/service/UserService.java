package com.neuedu.print.service;

import javax.servlet.http.HttpSession;

import com.neuedu.print.model.User;

public interface UserService {
	/**
	 * 注册
	 * @param user
	 */
	void regist(User user);
	 /**
	  * 登录
	  * @param user
	  * @return
	  */
    User login(String username, String password,HttpSession session);
	User login(User user);
}
