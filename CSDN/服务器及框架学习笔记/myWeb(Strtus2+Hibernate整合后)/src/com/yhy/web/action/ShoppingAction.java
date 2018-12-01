package com.yhy.web.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yhy.model.GoodsInfo;
import com.yhy.service.ShoppingService;
import com.yhy.service.impl.ShoppingServiceImpl;

public class ShoppingAction extends ActionSupport 
{
	List<GoodsInfo> goodsInfos=new ArrayList<GoodsInfo>();
	ShoppingService shoppingService=new ShoppingServiceImpl();
	GoodsInfo goodsInfo=new GoodsInfo();
	
	public String select()
	{
		//查询数据
		HttpServletRequest request=ServletActionContext.getRequest();
		int goodsID=0;
		if(!request.getParameter("goodsID").equals(""))
			goodsID=Integer.parseInt(request.getParameter("goodsID").trim());// 获取商品编号
		
		String goodsName="";
		goodsName=request.getParameter("goodsName");// 获取商品名字
		
		int goodsTypeID=0;
		if(!request.getParameter("goodsTypeID").equals(""))
			goodsTypeID=Integer.parseInt(request.getParameter("goodsTypeID").trim());//获取商品类型编号
		
		//查询商品
		if(goodsID!=0)
		{
			GoodsInfo goodsInfos2=shoppingService.selectGoodsID(goodsID);
			System.out.println(goodsInfos2);
			goodsInfos.add(goodsInfos2);		
		}
		
		if(goodsTypeID!=0 && goodsID==0)
		{
			Set<GoodsInfo>goodsInfos1=shoppingService.selectGoodsType(goodsTypeID);
			Iterator<GoodsInfo> iter=goodsInfos1.iterator();
			while(iter.hasNext())
			{
				goodsInfo=(GoodsInfo)iter.next();
				System.out.println(goodsInfo);
				goodsInfos.add(goodsInfo);
			}
		}
				
		if(!goodsName.equals(""))
		{
			goodsInfos=shoppingService.selectGoodsName(goodsName);
		}
				
		List<GoodsInfo> list=goodsInfos;
		for(GoodsInfo h:list)
		{
		  	System.out.println(h.getGoods_id().toString());
		  	System.out.println(h.getGoods_name());
		  	System.out.println(h.getGoods_price().toString());
		  	System.out.println(h.getGoodsType().getType_name());
		}
		
		ServletActionContext.getRequest().getSession().setAttribute("goodsInfo", goodsInfos);
		
		return SUCCESS;
	}
}
