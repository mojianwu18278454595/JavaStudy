package com.yhy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 实体类GoodsInfo
 * @author 知飞翀
 * CSDN   https://blog.csdn.net/biggerchong
 * QQ  610254602
 */
public class GoodsInfo
{
	private Integer goods_id;
	private String goods_name;
	private Double goods_price;
	private GoodsType goodsType;
	private Set<UserInfo> goods_userInfos=new HashSet<UserInfo>();
	
	public Set<UserInfo> getGoods_userInfos()
	{
		return goods_userInfos;
	}


	public void setGoods_userInfos(Set<UserInfo> goods_userInfos)
	{
		this.goods_userInfos = goods_userInfos;
	}


	@Override
	public String toString()
	{
		return "GoodsInfo [goods_id=" + goods_id + ", goods_name=" + goods_name + ", goods_price=" + goods_price + "]";
	}


	public GoodsInfo()
	{
		
	}

	
	public Integer getGoods_id()
	{
		return goods_id;
	}


	public void setGoods_id(Integer goods_id)
	{
		this.goods_id = goods_id;
	}


	public String getGoods_name()
	{
		return goods_name;
	}


	public void setGoods_name(String goods_name)
	{
		this.goods_name = goods_name;
	}


	public Double getGoods_price()
	{
		return goods_price;
	}


	public void setGoods_price(Double goods_price)
	{
		this.goods_price = goods_price;
	}


	public GoodsType getGoodsType()
	{
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType)
	{
		this.goodsType = goodsType;
	}
	
	
	
}
