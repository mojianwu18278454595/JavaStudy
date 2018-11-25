package com.yhy.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.yhy.model.GoodsInfo;
import com.yhy.model.UserInfo;
import com.yhy.tools.HibernateUtils;

public class ShoppingCarDao
{
	public ShoppingCarDao()
	{
		
	}
	
	//将商品添加至购物车,返回1:添加成功
	public int addToCar(int user_id,int goods_id)
	{
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		
		GoodsInfo goodsInfo=session.get(GoodsInfo.class, goods_id);
		UserInfo userInfo=session.get(UserInfo.class, user_id);
		userInfo.getUser_goodsInfos().add(goodsInfo);
		session.save(userInfo);
			
		tr.commit();
			
		return 1;
	}
		
	//读取当前用户的购物车商品
	public Set<GoodsInfo> readCar(int user_id)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr= session.beginTransaction();
			
		UserInfo userCurrent=session.get(UserInfo.class,user_id);
		Set<GoodsInfo> user_goodsInfos=userCurrent.getUser_goodsInfos();
		
		tr.commit();	
		return user_goodsInfos;
	}
		
	//从当前用户的购物车中移除,返回1:移除成功
	public int removeCar(int user_id,int goods_id)
	{
		Session session =HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
			
		UserInfo userCurrent=session.get(UserInfo.class,user_id);
		GoodsInfo goodsInfo=session.get(GoodsInfo.class, goods_id);
		userCurrent.getUser_goodsInfos().remove(goodsInfo);
			
		tr.commit();
			
		return 1;
	}
		

	//测试
	public static void main(String[] args)
	{
		ShoppingCarDao car=new ShoppingCarDao();
		car.addToCar(1, 1);
		
		Set<GoodsInfo> user_goodsInfos=car.readCar(1);
		Iterator<GoodsInfo> iter=user_goodsInfos.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
		car.removeCar(1, 1);
		
	}
}
