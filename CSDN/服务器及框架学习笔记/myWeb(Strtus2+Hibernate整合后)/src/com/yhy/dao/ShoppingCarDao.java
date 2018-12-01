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

public interface ShoppingCarDao
{	
	//将商品添加至购物车,返回1:添加成功
	public int addToCar(int user_id,int goods_id);
		
	//读取当前用户的购物车商品
	public Set<GoodsInfo> readCar(int user_id);
		
	//从当前用户的购物车中移除,返回1:移除成功
	public int removeCar(int user_id,int goods_id);

}
