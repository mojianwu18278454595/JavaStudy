package com.yhy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 实体类UserInfo
 * @author 知飞翀
 * CSDN https://blog.csdn.net/biggerchong
 * QQ   610254602
 */
public class UserInfo
{
	@SuppressWarnings("unused")
	private Integer user_id;
	private String user_name;
	private String user_pwd;
	private String user_gender;
	private String user_tel;
	private String user_address;
	private Integer user_type;
	private Set<GoodsInfo> user_goodsInfos=new HashSet<GoodsInfo>();
	
	public Set<GoodsInfo> getUser_goodsInfos()
	{
		return user_goodsInfos;
	}

	public void setUser_goodsInfos(Set<GoodsInfo> user_goodsInfos)
	{
		this.user_goodsInfos = user_goodsInfos;
	}

	public UserInfo()
	{
		
	}

	public Integer getUser_id()
	{
		return user_id;
	}

	public void setUser_id(Integer user_id)
	{
		this.user_id = user_id;
	}

	public String getUser_name()
	{
		return user_name;
	}

	public void setUser_name(String user_name)
	{
		this.user_name = user_name;
	}

	public String getUser_pwd()
	{
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd)
	{
		this.user_pwd = user_pwd;
	}

	public String getUser_gender()
	{
		return user_gender;
	}

	public void setUser_gender(String user_gender)
	{
		this.user_gender = user_gender;
	}

	public String getUser_tel()
	{
		return user_tel;
	}

	public void setUser_tel(String user_tel)
	{
		this.user_tel = user_tel;
	}

	public String getUser_address()
	{
		return user_address;
	}

	public void setUser_address(String user_address)
	{
		this.user_address = user_address;
	}

	public Integer getUser_type()
	{
		return user_type;
	}

	public void setUser_type(Integer user_type)
	{
		this.user_type = user_type;
	}

	@Override
	public String toString()
	{
		return "UserInfo [user_id=" + user_id + ", user_name=" + user_name + ", user_pwd=" + user_pwd + ", user_gender="
				+ user_gender + ", user_tel=" + user_tel + ", user_address=" + user_address + ", user_type=" + user_type
				+ "]";
	}
	
	
}
