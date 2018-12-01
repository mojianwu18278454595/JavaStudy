package com.yhy.web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yhy.model.UserInfo;
import com.yhy.service.UserService;
import com.yhy.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<UserInfo>
{
	private UserInfo userInfo=new UserInfo();
	private UserService userService=new UserServiceImpl();
	@Override
	public UserInfo getModel()
	{
		return userInfo;
	}
	
	//登录验证
	public String login()
	{
		System.out.println(userInfo);
		UserInfo checkLogin=userService.login(userInfo);
		if(checkLogin==null)
		{
			this.addActionError("亲，您输入的用户名或密码错误！");
			return ERROR;
		}
		ServletActionContext.getRequest().getSession().setAttribute("userInfo", checkLogin);
		return LOGIN;
	}
	
	//注册
	public String register()
	{
		System.out.println(userInfo);
		String pwdAgin=(String)ServletActionContext.getRequest().getParameter("pwdAgin").trim();
		if(pwdAgin.equals(userInfo.getUser_pwd()))
		{
			userInfo.setUser_type(0);
			UserInfo checkRegister=userService.register(userInfo);
			if(checkRegister==null)
			{
				this.addActionError("亲，您注册的用户已经被注册！");
				return "errorRegister";
			}
			ServletActionContext.getRequest().getSession().setAttribute("userInfo", checkRegister);
		}
		else
		{
			this.addActionError("亲，密码输入不一致！");
			return "errorRegister";
		}
			
		return LOGIN;
	}
}
