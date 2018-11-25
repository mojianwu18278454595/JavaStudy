
package com.yhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yhy.model.Shooping;
import com.yhy.model.User;
import com.yhy.model.orderDetail;
import com.yhy.model.shoppingCar;
import com.yhy.tools.ConnDB;

public class shoppingCarDao
{
	private ConnDB conn = null;

	public shoppingCarDao() {
		conn = new ConnDB();
	}
	
	//将商品添加到购物车中,返回1为添加成功，返回0为添加失败
	public int addShoppingCar(Shooping shop,int id)
	{	
		int flag=0;
		ShoopingDao shopping=new ShoopingDao();
		shopping.selectGoodsID(shop);
		
		String sql="INSERT INTO tb_car(id,goodsID) VALUES ('"+id
				+"','"+shop.getGoodsID()+"')";
		try
		{
			//执行插入sql语句
			conn.executeUpdate(sql);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conn.close();// 关闭数据库连接
		}
		
		return flag;
	}

	
	//读取购物车,返回listCar是购物车清单
	public ArrayList<shoppingCar> readShoppingCar()
	{	
		ArrayList<shoppingCar> listCar=new ArrayList<shoppingCar>();
		String sql = "SELECT * FROM tb_car";
		ResultSet rs = null;
		try {
			rs = conn.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 执行SQL语句
		try {
			
			while(rs.next()) {
					listCar.add(new shoppingCar(rs.getInt(1),rs.getInt(2),rs.getInt(3)));		
			}
		} catch (SQLException ex) {
			ex.printStackTrace();// 输出异常信息
			
		} finally {
			conn.close();// 关闭数据库连接
		}
		
		return listCar;
	}




	//订单数据显示,返回订单信息；若返回订单信息为null，表示显示失败
	public orderDetail putOrderDetail(ArrayList<shoppingCar> listCar)
	{	
		Shooping shop=new Shooping();
		orderDetail od=new orderDetail();
		double sumPrice=0;
		
		for(int i=0;i<listCar.size();i++)
		{
			String sql = "SELECT * FROM tb_goodsInfo WHERE goodsID='"
					+ listCar.get(i).getGoodsID() + "'";
			ResultSet rs = null;
			try {
				rs = conn.executeQuery(sql);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 执行SQL语句
			try {
				
				if(rs.next()) {
					
					shop.setGoodsID(rs.getInt(1));
					shop.setGoodsTypeID(rs.getInt(2));
					shop.setGoodsName(rs.getString(3));
					shop.setGoodsPrice(rs.getDouble(4));
					shop.setGoodsPictureID(rs.getInt(5));					
						
					sumPrice=sumPrice+shop.getGoodsPrice();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();// 输出异常信息
				
			}
			
		}
		
		od.setTotalPrice(sumPrice);
		conn.close();// 关闭数据库连接
		
		return od;
	}
	
	//将商品从购物车中移除,返回1为移除成功，返回0为移除失败
		public int delShoppingCar(Shooping shop)
		{	
			int flag=0;
			ShoopingDao shopping=new ShoopingDao();
			shopping.selectGoodsID(shop);
			
			String sql="DELETE FROM tb_car WHERE `goodsID`= '"+shop.getGoodsID()+"'";
			try
			{
				//执行插入sql语句
				conn.executeUpdate(sql);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				conn.close();// 关闭数据库连接
			}
			
			return flag;
		}
	
	
}