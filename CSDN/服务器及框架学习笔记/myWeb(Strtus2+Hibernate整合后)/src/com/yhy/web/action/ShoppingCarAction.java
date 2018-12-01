package com.yhy.web.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yhy.model.GoodsInfo;
import com.yhy.model.UserInfo;
import com.yhy.service.ShoppingCarService;
import com.yhy.service.impl.ShoppingCarServiceImpl;

public class ShoppingCarAction extends ActionSupport
{
	private ShoppingCarService shoppingCarService=new ShoppingCarServiceImpl();
	
	public String addOrDelCar()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		int user_id=0;
		user_id=userInfo.getUser_id();
		if(user_id!=0)
		{
		String[] goods=request.getParameterValues("addGoods");
		String[] delGoods=request.getParameterValues("delGoods");
		
		if(goods!=null)
		for(String good:goods)
		{
			String[]goodz=good.split(":");
			int goods_id=Integer.parseInt(goodz[0]);
				
			//添加到tb_car中
			shoppingCarService.addToCar(user_id, goods_id);
		}
			
		if(delGoods!=null)
		for(String del:delGoods)
		{
			String[]delz=del.split(":");
			int goods_id=Integer.parseInt(delz[0]);
				
			//从tb_car中移除
			shoppingCarService.removeCar(user_id, goods_id);
		}
		
		}	
		//取出购物车中的商品
		
		Set<GoodsInfo> user_goodsInfos=shoppingCarService.readCar(user_id);
		List<GoodsInfo> myShop=new ArrayList<GoodsInfo>(user_goodsInfos);
		
		ServletActionContext.getRequest().getSession().setAttribute("carShopping", myShop);
		
		return SUCCESS;
	}
	
}
