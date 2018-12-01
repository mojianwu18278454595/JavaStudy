package com.yhy.service;

import java.util.List;
import java.util.Set;

import com.yhy.model.GoodsInfo;

public interface ShoppingService
{

	public GoodsInfo selectGoodsID(int goodsID);

	public Set<GoodsInfo> selectGoodsType(int goodsTypeID);

	public List<GoodsInfo> selectGoodsName(String goodsName);

}
