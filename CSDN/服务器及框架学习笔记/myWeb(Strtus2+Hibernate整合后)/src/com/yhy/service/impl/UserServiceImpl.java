package com.yhy.service.impl;

import com.yhy.dao.UserDao;
import com.yhy.dao.impl.UserDaoImpl;
import com.yhy.model.UserInfo;
import com.yhy.service.UserService;

public class UserServiceImpl implements UserService
{
	private UserDao userDao=new UserDaoImpl();

	@Override
	public UserInfo login(UserInfo userInfo)
	{
		
		UserInfo checkLogin=userDao.loginCheck(userInfo);
		
		return checkLogin;
	}

	@Override
	public UserInfo register(UserInfo userInfo)
	{
		UserInfo checkRegister=userDao.registerUser(userInfo);
		
		return checkRegister;
	}
	
}
