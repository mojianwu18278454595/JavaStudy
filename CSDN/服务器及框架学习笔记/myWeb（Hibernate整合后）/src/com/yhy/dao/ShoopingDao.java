package com.yhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.yhy.model.GoodsInfo;
import com.yhy.model.GoodsType;
import com.yhy.tools.HibernateUtils;


public class ShoopingDao {
	public ShoopingDao()
	{
		
	}
	
	//按商品类型查找
	public Set<GoodsInfo> selectGoodsType(int type_id)
	{
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		
		GoodsType giveType=session.get(GoodsType.class,type_id);
		Set<GoodsInfo> goodsInfos=giveType.getGoodsInfos();
		
		tr.commit();
		
		return goodsInfos;
	}
	
	//按商品ID
	public GoodsInfo selectGoodsID(int goods_id)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr= session.beginTransaction();
		
		Integer goods=new Integer(goods_id); 
		GoodsInfo goodsInfo=session.get(GoodsInfo.class,goods);
		
		tr.commit();
		
		return goodsInfo;
	}
	
	//按商品名称
	public List<GoodsInfo> selectGoodsName(String goods_name)
	{
		Session session =HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		
		Criteria criteria = session.createCriteria(GoodsInfo.class);
		criteria.add(Restrictions.like("goods_name",goods_name+"%"));
		List<GoodsInfo> goodsInfos=criteria.list();
		tr.commit();
		
		return goodsInfos;
	}
	

	//测试
	public static void main(String[] args)
	{
		GoodsInfo goodsInfo;
		ShoopingDao shop=new ShoopingDao();
//		Set<GoodsInfo>goodsInfos1=shop.selectGoodsType(1);
//		Iterator<GoodsInfo> iter=goodsInfos1.iterator();
//		while(iter.hasNext())
//		{
//			goodsInfo=(GoodsInfo)iter.next();
//			System.out.println(goodsInfo);
//		}
		
		GoodsInfo goodsInfos2=shop.selectGoodsID(1);
		System.out.println(goodsInfos2);
		
		List<GoodsInfo> goodsInfos3=shop.selectGoodsName("男士");
		for (GoodsInfo goodsInfos : goodsInfos3)
		{
			System.out.println(goodsInfos);
		}
		
	}

}
