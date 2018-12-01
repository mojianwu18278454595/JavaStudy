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


public interface ShoppingDao {

	//按商品类型查找
	public Set<GoodsInfo> selectGoodsType(int type_id);
	
	//按商品ID
	public GoodsInfo selectGoodsID(int goods_id);
	
	//按商品名称
	public List<GoodsInfo> selectGoodsName(String goods_name);

}
