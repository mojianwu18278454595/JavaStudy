package com.yhy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 实体类GoodsType
 * @author 知飞翀
 * CSDN  https://blog.csdn.net/biggerchong
 * QQ   610254602
 */
public class GoodsType
{
	 private Integer type_id;
	 private String type_name;
	 private String type_icon;
	 private Set<GoodsInfo> goodsInfos=new HashSet<GoodsInfo>();
	 
	 public GoodsType()
	 {
		 
		 
	 }

	@Override
	public String toString()
	{
		return "GoodsType [type_id=" + type_id + ", type_name=" + type_name + ", type_icon=" + type_icon + "]";
	}

	public Set<GoodsInfo> getGoodsInfos()
	{
		return goodsInfos;
	}

	public void setGoodsInfos(Set<GoodsInfo> goodsInfos)
	{
		this.goodsInfos = goodsInfos;
	}

	public Integer getType_id()
	{
		return type_id;
	}

	public void setType_id(Integer type_id)
	{
		this.type_id = type_id;
	}

	public String getType_name()
	{
		return type_name;
	}

	public void setType_name(String type_name)
	{
		this.type_name = type_name;
	}

	public String getType_icon()
	{
		return type_icon;
	}

	public void setType_icon(String type_icon)
	{
		this.type_icon = type_icon;
	}

	
	 
}
