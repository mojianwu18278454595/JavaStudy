package com.yhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.yhy.model.Shooping;
import com.yhy.model.pictureInfo;
import com.yhy.tools.ConnDB;


public class ShoopingDao {
	private ConnDB conn = null;

	public ShoopingDao() {
		conn = new ConnDB();
	}

	// 按商品类型查找商品,listShop.size()为0表示没查到商品
	public ArrayList<Shooping> selectGoodsType(Shooping shop) {
		
		ArrayList<Shooping> listShop=new ArrayList<Shooping>();
		String sql = "SELECT * FROM tb_goodsInfo WHERE goodsTypeID='"
				+ shop.getGoodsTypeID() + "'";
		ResultSet rs = null;
		try {
			rs = conn.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 执行SQL语句
		try {
	
			while (rs.next()) {
					Shooping sh=new Shooping();
					sh.setGoodsName(rs.getString(3));
					sh.setGoodsID(rs.getInt(1));
					sh.setGoodsTypeID(shop.getGoodsTypeID());
					sh.setGoodsPrice(rs.getDouble(4));
					sh.setGoodsPictureID(rs.getInt(5));
					
					listShop.add(sh);
					
			}
		} catch (SQLException ex) {
			ex.printStackTrace();// 输出异常信息
			
		} finally {
			conn.close();// 关闭数据库连接
		}
		
		return listShop;
	}

	
	//按商品名称查询
	public ArrayList<Shooping> selectGoodsName(Shooping shop) {
		ArrayList<Shooping> listShop=new ArrayList<Shooping>();
		String sql = "SELECT * FROM tb_goodsInfo WHERE goodsName LIKE '"
				+ shop.getGoodsName() + "%'";
		ResultSet rs = null;
		try {
			rs = conn.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 执行SQL语句
		try {
			
			while (rs.next()) {
				
					shop.setGoodsName(rs.getString(3));
					shop.setGoodsID(rs.getInt(1));
					shop.setGoodsTypeID(rs.getInt(2));
					shop.setGoodsPrice(rs.getDouble(4));
					shop.setGoodsPictureID(rs.getInt(5));
					
					listShop.add(shop);
					
			}
		} catch (SQLException ex) {
			ex.printStackTrace();// 输出异常信息
			
		} finally {
			conn.close();// 关闭数据库连接
		}
		
		return listShop;
	}

	
	
	//按商品ID查找,返回1为查找成功，返回0为查找失败
	public  ArrayList<Shooping> selectGoodsID(Shooping shop) {
		
		ArrayList<Shooping> listShop=new ArrayList<Shooping>();
		String sql = "SELECT * FROM tb_goodsInfo WHERE goodsID = '"
				+ shop.getGoodsID() + "%'";
		ResultSet rs = null;
		try {
			rs = conn.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 执行SQL语句
		try {
			
			if (rs.next()) {
				
					shop.setGoodsID(rs.getInt(1));
					shop.setGoodsTypeID(rs.getInt(2));
					shop.setGoodsName(rs.getString(3));
					shop.setGoodsPrice(rs.getDouble(4));
					shop.setGoodsPictureID(rs.getInt(5));
					
					listShop.add(shop);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();// 输出异常信息
			
		} finally {
			conn.close();// 关闭数据库连接
		}
		
		return listShop;
	}

	
	
	
	
	//显示商品具体信息,返回1为信息读取成功，返回0为信息读取失败
	public int putGoodsInfo(Shooping shop,pictureInfo picture) {
		
		int flag=0;
		String sql = "SELECT * FROM tb_picture WHERE pictureID = '"
				+ shop.getGoodsPictureID() + "%'";
		ResultSet rs = null;
		try {
			rs = conn.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 执行SQL语句
		try {
			rs.last(); // 定位到最后一条记录
			int rowSum = rs.getRow();// 获取记录总数
			rs.first();// 定位到第一条记录
			
			if (rs.next()) {
				
					picture.setPictureID(rs.getInt(1));
					picture.setPictureName(rs.getString(3));
					picture.setIntroduction(rs.getString(2));
					flag=1;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();// 输出异常信息
			flag=0;
		} finally {
			conn.close();// 关闭数据库连接
		}
		
		return flag;
	}

	//测试
	public static void main(String[] args)
	{
		ArrayList<Shooping> list=new ArrayList<Shooping>();
		ShoopingDao s=new ShoopingDao();
		Shooping shop=new Shooping();
		shop.setGoodsTypeID(1);
		list=s.selectGoodsType(shop);
		
		for(Shooping h:list)
		{
			System.out.println(h.getGoodsID());
		}
	}

}
