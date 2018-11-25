package com.yhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yhy.dao.ShoopingDao;
import com.yhy.model.GoodsInfo;

public class shoppingServlet extends HttpServlet
{
	ShoopingDao shoppingDao;
	List<GoodsInfo> goodsInfos;
	/**
	 * Constructor of the object.
	 */
	public shoppingServlet()
	{
		super();
		shoppingDao=new ShoopingDao();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);// 执行doPost()方法
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		goodsInfos=new ArrayList<GoodsInfo>();
		GoodsInfo goodsInfo=new GoodsInfo();
		//获取打印流对象
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
				
		request.setCharacterEncoding("utf-8");
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
			GoodsInfo goodsInfos2=shoppingDao.selectGoodsID(goodsID);
			System.out.println(goodsInfos2);
			goodsInfos.add(goodsInfos2);
		}
		if(goodsTypeID!=0 && goodsID==0)
		{
			Set<GoodsInfo>goodsInfos1=shoppingDao.selectGoodsType(goodsTypeID);
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
			goodsInfos=shoppingDao.selectGoodsName(goodsName);
		}
		
		List<GoodsInfo> list=goodsInfos;
  		for(GoodsInfo h:list)
  		{
  			System.out.println(h.getGoods_id().toString());
  			System.out.println(h.getGoods_name());
  			System.out.println(h.getGoods_price().toString());
  			System.out.println(h.getGoodsType().getType_name());
  		}
		
		request.setAttribute("listShop", goodsInfos);
		
		request.getRequestDispatcher("goodsInfo.jsp").forward(request,response);
	}

	

}
