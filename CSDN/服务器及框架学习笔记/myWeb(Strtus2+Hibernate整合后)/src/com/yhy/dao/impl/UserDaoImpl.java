package com.yhy.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yhy.dao.UserDao;
import com.yhy.model.UserInfo;
import com.yhy.tools.HibernateUtils;

public class UserDaoImpl implements UserDao {
	
	//登录信息验证，返回0:密码不对；返回-1：无此用户；
	public  UserInfo loginCheck(UserInfo userInfo)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		//在数据库中查找输入用户名的记录是否存在
		Query query=session.createQuery("from UserInfo where user_name=? and user_pwd=?");
		query.setParameter(0, userInfo.getUser_name());
		query.setParameter(1, userInfo.getUser_pwd());
		UserInfo userCheck=(UserInfo)query.uniqueResult();
		tr.commit();
		return userCheck;
	}
	
	//注册用户,返回0：用户名已存在；
	public UserInfo registerUser(UserInfo userInfo)
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
			return userInfo;
		}
		
		tr.commit();
		return null;
	}
	
}








