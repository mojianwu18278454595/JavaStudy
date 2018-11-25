package com.yhy.model;

public class shoppingCar
{
	private int carID;
	private int goodsID;
	private int id;
	
	
	public int getCarID()
	{
		return carID;
	}
	public void setCarID(int carID)
	{
		this.carID = carID;
	}
	public int getGoodsID()
	{
		return goodsID;
	}
	public void setGoodsID(int goodsID)
	{
		this.goodsID = goodsID;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public shoppingCar()
	{
		
	}
	
	public shoppingCar(int carID,int id,int goodsID)
	{
		this.carID=carID;
		this.goodsID=goodsID;
		this.id=id;
	}
	
}
