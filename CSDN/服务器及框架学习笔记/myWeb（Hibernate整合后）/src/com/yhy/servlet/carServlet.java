package com.yhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yhy.dao.ShoopingDao;
import com.yhy.dao.ShoppingCarDao;
import com.yhy.model.GoodsInfo;


public class carServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ShoppingCarDao carDao = null;
	 

	/**
	 * Constructor of the object.
	 */
	public carServlet()
	{
		super();
		carDao=new ShoppingCarDao();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);// 执行doPost()方法
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
		
		ShoopingDao shoppingDao=new ShoopingDao();
		
		
		//获取打印流对象
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		
		int user_id=0;
		user_id=Integer.parseInt((String)session.getAttribute("id"));
		if(user_id!=0)
		{
			String[] goods=request.getParameterValues("addGoods");
			String[] delGoods=request.getParameterValues("delGoods");
			if(goods!=null)
				for(String good:goods)
				{
					String[]goodz=good.split(":");
					int goods_id=Integer.parseInt(goodz[0]);
//					shop.setGoodsName(goodz[1]);
//					shop.setGoodsPrice(Double.parseDouble(goodz[2]));
				
					//添加到tb_car中
					carDao.addToCar(user_id, goods_id);
				}
			
			if(delGoods!=null)
				for(String del:delGoods)
				{
					String[]delz=del.split(":");
					int goods_id=Integer.parseInt(delz[0]);
//					shop.setGoodsName(delz[1]);
//					shop.setGoodsPrice(Double.parseDouble(delz[2]));
				
					//从tb_car中移除
					carDao.removeCar(user_id, goods_id);
				}
			
		}
		
		//取出购物车中的商品
		ArrayList<GoodsInfo> myShop=new ArrayList<GoodsInfo>();
		Set<GoodsInfo> user_goodsInfos=carDao.readCar(user_id);
		Iterator<GoodsInfo> iter=user_goodsInfos.iterator();
		while(iter.hasNext())
		{
			myShop.add((GoodsInfo)iter.next());
		}
		
		session.setAttribute("carShopping", myShop);
		request.getRequestDispatcher("car.jsp").forward(request,response);// 请求转发页面
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException
	{
		// Put your code here
	}

}
