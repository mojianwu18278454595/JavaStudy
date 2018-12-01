package com.yhy.service;

import java.util.Set;

import com.yhy.model.GoodsInfo;

public interface ShoppingCarService
{

	public void addToCar(int user_id, int goods_id);

	public void removeCar(int user_id, int goods_id);

	public Set<GoodsInfo> readCar(int user_id);

}
