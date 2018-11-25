package com.yhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yhy.model.UserInfo;
import com.yhy.tools.ConnDB;
import com.yhy.tools.HibernateUtils;

public class UserDao {
	
	public UserDao()
	{
		
	}
	
	//登录信息验证，返回0:密码不对；返回-1：无此用户；
	public  int loginCheck(UserInfo userInfo)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		//在数据库中查找输入用户名的记录是否存在
		Query query=session.createQuery("from UserInfo where user_name=?");
		query.setParameter(0, userInfo.getUser_name());
		UserInfo userCheck=(UserInfo)query.uniqueResult();
		tr.commit();
		
		if(userCheck.getUser_id()>0)
		{
			//判断密码是否正确
			if(userCheck.getUser_pwd().equals(userInfo.getUser_pwd()))
			{
				System.out.println("密码输入正确！");
				userInfo.setUser_id(userCheck.getUser_id());
				userInfo.setUser_tel(userCheck.getUser_tel());
				userInfo.setUser_address(userCheck.getUser_address());
				userInfo.setUser_type(userCheck.getUser_type());
				userInfo.setUser_gender(userCheck.getUser_gender());
				return userCheck.getUser_id();
			}
			else
				return 0;
		}
		
		return -1;
	}
	
	//注册用户,返回0：用户名已存在；
	public int registerUser(UserInfo userInfo)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		//在数据库中查找输入用户名的记录是否存在
		Query query=session.createQuery("from UserInfo where user_name=?");
		query.setParameter(0, userInfo.getUser_name());
		UserInfo userCheck=(UserInfo)query.uniqueResult();
		
		if(userCheck==null)
		{
			session.save(userInfo);
			tr.commit();
			return userInfo.getUser_id();
		}
		
		tr.commit();
		return 0;
	}
	
}








