package com.yhy.service.impl;

import java.util.List;
import java.util.Set;

import com.yhy.dao.ShoppingDao;
import com.yhy.dao.impl.ShoppingDaoImpl;
import com.yhy.model.GoodsInfo;
import com.yhy.service.ShoppingService;

public class ShoppingServiceImpl implements ShoppingService
{
	ShoppingDao shoppingDao=new ShoppingDaoImpl();
	
	@Override
	public GoodsInfo selectGoodsID(int goodsID)
	{
		GoodsInfo goodsInfo=shoppingDao.selectGoodsID(goodsID);
		return goodsInfo;
	}

	@Override
	public Set<GoodsInfo> selectGoodsType(int goodsTypeID)
	{
		return shoppingDao.selectGoodsType(goodsTypeID);
	}

	@Override
	public List<GoodsInfo> selectGoodsName(String goodsName)
	{
		return shoppingDao.selectGoodsName(goodsName);
	}

}
