package com.yhy.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.yhy.dao.ShoppingDao;
import com.yhy.model.GoodsInfo;
import com.yhy.model.GoodsType;
import com.yhy.tools.HibernateUtils;

public class ShoppingDaoImpl implements ShoppingDao
{
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
}
