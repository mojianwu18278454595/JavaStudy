/*
 * Author：知飞翀
 * CSDN：https://me.csdn.net/biggerchong
 * Task：加载、解析properties文件
 */

package com.sc.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class testProperties
{
	Properties proper;
	
	public testProperties()
	{
		proper=new Properties();
		
		load();
		parse();
	}
	
	//加载properties文件
	private void load()
	{
		
		/*说明：config.properties文件路径是相对路径，
		properties文件不支持中文，输入中文会自动转码（可以自行编码/解码传输中文）*/
		InputStream file=testProperties.class.getResourceAsStream("/config.properties");
		try
		{
			proper.load(file); //将流加载到proper
			file.close(); //inputStream流关闭
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//解析properties文件
	private void parse()
	{
		//当不存在Name关键字时，取默认值
		String Name=proper.getProperty("Name","知飞翀");//第二个参数是设置的默认值(可设可不设)
		String CSDN=proper.getProperty("CSDN");
		String QQ=proper.getProperty("QQ");
		
		System.out.println("**********Properties测试***********");
		System.out.println("Name:"+Name);
		System.out.println("CSDN:"+CSDN);
		System.out.println("QQ:"+QQ);
		System.out.println("**********************************");
	}

}
