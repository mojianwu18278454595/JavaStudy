package com.yhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yhy.model.User;
import com.yhy.tools.ConnDB;

public class UserDao {
	private ConnDB conn = null;

	public UserDao() {
		conn = new ConnDB();
	}

	// 验证用户的方法，返回值为1表示登录成功，否则表示登录失败
	public int login(User user) {
		int flag = 0;
		String sql = "SELECT * FROM tb_userInfo WHERE username='"
				+ user.getUsername() + "'";
		ResultSet rs = null;
		try {
			rs = conn.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 执行SQL语句
		try {
			if (rs.next()) {
				String pwd = user.getPwd();// 获取密码
				int id = rs.getInt(1);// 获取第一列的数据
				String tt=rs.getString(3);
				pwd = pwd.replaceAll("\\s", "");
				tt=tt.replaceAll("\\s", "");
				
				boolean s;
				s=tt.equals(pwd);
			//System.out.println(s);
				if (s) {
					flag = id;
					user.setGender(rs.getString(4));
					user.setTel(rs.getString(5));
					user.setType(rs.getInt(7));
					user.setAddress(rs.getString(6));
					rs.last(); // 定位到最后一条记录
					int rowSum = rs.getRow();// 获取记录总数
					rs.first();// 定位到第一条记录
					if (rowSum != 1) {
						flag = 0;
					}
				} else {
					flag = 0;
				}
			} else {
				flag = 0;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();// 输出异常信息
			flag = 0;
		} finally {
			conn.close();// 关闭数据库连接
		}
		
		return flag;
	}

	/**
	 * 功能：检测用户名是否已被注册
	 * 
	 * @param sql
	 * @return
	 */
	public String checkUser(String sql) {
		ResultSet rs = null;
		try {
			// 执行查询语句
			rs = conn.executeQuery(sql);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		String result = "";
		try {
			if (rs.next()) {
				result = "很抱歉，[" + rs.getString(2) + "]已经被注册！";
			} else {
				result = "1"; // 表示用户没有被注册
			}
		} catch (SQLException e) {
			e.printStackTrace(); // 输出异常信息
		} 
		return result; // 返回判断结果
	}


//注册用户，返回1为注册成功，返回0为注册失败,返回2为用户名已被注册
public int register(User user)
{
	String sql="SELECT * FROM tb_userInfo WHERE username='"
				+ user.getUsername()+ "'";
	String result=this.checkUser(sql);
	
	//判断是否被注册
	if(result.equals("1"))
	{
		sql="INSERT INTO tb_userInfo( username,pwd,gender,tel,type) VALUES ('"+user.getUsername()
				+"','"+user.getPwd()+"','"
				+user.getGender()+"','"+user.getTel()+"','"+user.getType()+"')";
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
		
	}
	else
	{	
		conn.close();// 关闭数据库连接
		return 2;
	}
	
	
	return 1;
	
}



}








