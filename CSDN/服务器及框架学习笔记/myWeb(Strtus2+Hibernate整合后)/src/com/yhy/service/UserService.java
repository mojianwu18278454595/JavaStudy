package com.yhy.service;

import com.yhy.model.UserInfo;

public interface UserService
{

  public UserInfo login(UserInfo userInfo);

  public UserInfo register(UserInfo userInfo);
	
}
