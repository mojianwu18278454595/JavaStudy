package com.yhy.tools;
/**
 * 实体类GoodsCar
 * @author 知飞翀
 * CSDN  https://blog.csdn.net/biggerchong
 * QQ   610254602
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils
{
	private static final Configuration cf;
	private static final SessionFactory sf;
	static
	{
		cf=new Configuration().configure();
		sf=cf.buildSessionFactory();
	}
	
	//生成session
	public static Session getSession()
	{
		return sf.openSession();
	}
	public static Session getCurrentSession()
	{
		return sf.getCurrentSession();
	}
}
