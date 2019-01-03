package com.sc.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//Hibernate生成Session封装类
public class HibernateUtils
{
	private static final Configuration cfg;
	private static final SessionFactory sf;
	
	static 
	{
		cfg=new Configuration().configure();
		sf=cfg.buildSessionFactory();
	}
	
	public static Session getSession()
	{
		return sf.openSession();
	}
	
	public static Session getCurrentSession()
	{
		return sf.getCurrentSession();
	}
}
