package com.yhy.dao.impl;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yhy.dao.ShoppingCarDao;
import com.yhy.model.GoodsInfo;
import com.yhy.model.UserInfo;
import com.yhy.tools.HibernateUtils;

public class ShoppingCarDaoImpl implements ShoppingCarDao
{
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
		
}
