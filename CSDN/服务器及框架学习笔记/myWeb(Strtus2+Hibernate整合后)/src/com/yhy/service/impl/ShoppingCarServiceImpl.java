package com.yhy.service.impl;

import java.util.Set;

import com.yhy.dao.ShoppingCarDao;
import com.yhy.dao.impl.ShoppingCarDaoImpl;
import com.yhy.model.GoodsInfo;
import com.yhy.service.ShoppingCarService;

public class ShoppingCarServiceImpl implements ShoppingCarService
{

	@Override
	public void addToCar(int user_id, int goods_id)
	{
		ShoppingCarDao shoppingCarDao=new ShoppingCarDaoImpl();
		shoppingCarDao.addToCar(user_id, goods_id);
	}

	@Override
	public void removeCar(int user_id, int goods_id)
	{
		ShoppingCarDao shoppingCarDao=new ShoppingCarDaoImpl();
		shoppingCarDao.removeCar(user_id, goods_id);
	}

	@Override
	public Set<GoodsInfo> readCar(int user_id)
	{
		ShoppingCarDao shoppingCarDao=new ShoppingCarDaoImpl();
		return shoppingCarDao.readCar(user_id);
	}

}
