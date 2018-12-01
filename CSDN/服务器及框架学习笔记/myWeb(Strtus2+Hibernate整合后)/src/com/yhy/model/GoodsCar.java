package com.yhy.model;
/**
 * 实体类GoodsCar
 * @author 知飞翀
 * CSDN  https://blog.csdn.net/biggerchong
 * QQ   610254602
 */
public class GoodsCar
{
	private Integer car_id;
	private Integer car_goods_id;
	private UserInfo userInfo;
	
	public GoodsCar()
	{
		
	}

	
	@Override
	public String toString()
	{
		return "GoodsCar [car_id=" + car_id + ", car_goods_id=" + car_goods_id + "]";
	}


	public Integer getCar_id()
	{
		return car_id;
	}


	public void setCar_id(Integer car_id)
	{
		this.car_id = car_id;
	}


	public Integer getCar_goods_id()
	{
		return car_goods_id;
	}


	public void setCar_goods_id(Integer car_goods_id)
	{
		this.car_goods_id = car_goods_id;
	}


	public UserInfo getUserInfo()
	{
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo)
	{
		this.userInfo = userInfo;
	}

}
