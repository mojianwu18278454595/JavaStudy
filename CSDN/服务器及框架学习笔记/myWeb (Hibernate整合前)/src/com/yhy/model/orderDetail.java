package com.yhy.model;

public class orderDetail
{
	private int odID;
	private int id;
	private double totalPrice;
	private int goodsID;
	private int odStatus;
	private int carID;
	
	public int getCarID()
	{
		return carID;
	}
	public void setCarID(int carID)
	{
		this.carID = carID;
	}
	public int getOdID()
	{
		return odID;
	}
	public void setOdID(int odID)
	{
		this.odID = odID;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public double getTotalPrice()
	{
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	public int getGoodsID()
	{
		return goodsID;
	}
	public void setGoodsID(int goodsID)
	{
		this.goodsID = goodsID;
	}
	public int getOdStatus()
	{
		return odStatus;
	}
	public void setOdStatus(int odStatus)
	{
		this.odStatus = odStatus;
	}
	
	public orderDetail()
	{
		
	}
	
}
