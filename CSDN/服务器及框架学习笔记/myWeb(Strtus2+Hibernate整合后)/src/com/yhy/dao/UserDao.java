package com.yhy.dao;

import com.yhy.model.UserInfo;


public interface UserDao {
	
	//登录信息验证，返回0:密码不对；返回-1：无此用户；
	public UserInfo loginCheck(UserInfo userInfo);
	
	//注册用户,返回0：用户名已存在；
	public UserInfo registerUser(UserInfo userInfo);
	
}








