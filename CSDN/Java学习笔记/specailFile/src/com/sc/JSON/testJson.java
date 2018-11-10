package com.sc.JSON;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.json.JSONObject;

public class testJson
{
	JSONObject jsonObject;
	
	public testJson()
	{
		jsonObject=new JSONObject();
		
		create();
		parse();	
	}
	
	//创建JSON文件
	private void create()
	{
		jsonObject.put("name", "知飞翀");
		jsonObject.put("CSDN", "https://me.csdn.net/biggerchong");
		jsonObject.put("QQ",610254602);
		String jsonstr=jsonObject.toString(2); //缩进为2
		byte[] jsonByte=jsonstr.getBytes();
		
		try
		{
			FileOutputStream stream=new FileOutputStream("src/config.json");
			stream.write(jsonByte);
			stream.close();
			System.out.println("*************XML测试**************");
			System.out.println("config.json文件创建成功！");
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//解析JSON文件
	private void parse()
	{
		try
		{
			FileInputStream stream=new FileInputStream("src/config.json");
			byte[] jsonByte=new byte[1024];
			stream.read(jsonByte);
			stream.close();
			String jsonstr=new String(jsonByte);
			
			//解析
			JSONObject jsonObject=new JSONObject(jsonstr);
			String name=jsonObject.getString("name");
			String CSDN=jsonObject.getString("CSDN");
			int QQ=jsonObject.getInt("QQ");
			
			System.out.println("Name:"+name);
			System.out.println("CSDN:"+CSDN);
			System.out.println("QQ:"+QQ);
			System.out.println("**********************************");
			
			
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
