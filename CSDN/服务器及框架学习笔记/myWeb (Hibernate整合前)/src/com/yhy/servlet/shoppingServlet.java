package com.yhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yhy.dao.ShoopingDao;
import com.yhy.model.Shooping;

public class shoppingServlet extends HttpServlet
{
	ShoopingDao shoppingDao;
	Shooping  shopping;
	ArrayList<Shooping> listShop;

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
		shopping=new Shooping();
		listShop=new ArrayList<Shooping>();
		//获取打印流对象
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
				
		request.setCharacterEncoding("utf-8");
		int goodsID=0;
		if(!request.getParameter("goodsID").equals(""))
			goodsID=Integer.parseInt(request.getParameter("goodsID").trim());
		shopping.setGoodsID(goodsID); // 获取商品编号
		
		String goodsName="";
		goodsName=request.getParameter("goodsName");
		shopping.setGoodsName(goodsName); // 获取商品名字
		
		int goodsTypeID=0;
		if(!request.getParameter("goodsTypeID").equals(""))
			goodsTypeID=Integer.parseInt(request.getParameter("goodsTypeID").trim());
		shopping.setGoodsTypeID(goodsTypeID);//获取商品类型编号
		
		//查询商品
		if(goodsID!=0)
			listShop=shoppingDao.selectGoodsID(shopping);
		if(goodsTypeID!=0 && goodsID==0)
			listShop=shoppingDao.selectGoodsType(shopping);
		if(!goodsName.equals(""))
			listShop=shoppingDao.selectGoodsName(shopping);
		
		request.setAttribute("listShop", listShop);
		
		request.getRequestDispatcher("goodsInfo.jsp").forward(request,response);
	}

	

}
