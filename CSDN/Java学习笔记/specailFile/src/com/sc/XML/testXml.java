/*
 * Author：知飞翀
 * CSDN：https://me.csdn.net/biggerchong
 * QQ:610254602
 * dom4j developer: https://dom4j.github.io/javadoc/1.6.1/
 * Task：加载、生成、解析XML文件
 */

package com.sc.XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class testXml
{
	Document x_doc;
	
	public testXml()
	{
		//创建Document(加载准备)
		x_doc=DocumentHelper.createDocument();
		
		create();
		parse();	
	}
	
	
	
	//创建XML
	private void create()
	{
		//添加root根元素
		Element doc_root=x_doc.addElement("root");
		//添加子元素
		Element doc_name=doc_root.addElement("name").addText("知飞翀");
		Element doc_CSDN=doc_root.addElement("CSDN").addText("https://me.csdn.net/biggerchong");
		//添加属性
		Element name_QQ=doc_name.addAttribute("QQ", "610254602");
		
		//转成XML字符串
		x_doc.setXMLEncoding("UTF-8");
		
		//输出到文件
		OutputFormat format= OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8"); //设置XML字符编码
		File file=new File("src/config.xml"); //设置相对路径
		try
		{
			XMLWriter writer=new XMLWriter(new FileOutputStream(file),format);
			writer.write(x_doc);
			writer.close();
			System.out.println("*************XML测试**************");
			System.out.println("config.xml文件创建成功！");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
				
	}
	
	//解析XML
	private void parse()
	{
		try
		{
			//从文件中读出
			FileInputStream stream=new FileInputStream("src/config.xml");
			SAXReader reader=new SAXReader();
			
			Document x_doc=reader.read(stream);
			stream.close();
			//取得根元素
			Element doc_root=x_doc.getRootElement();
			
			//从子元素中取值
			  //方法1
			Element doc_name=doc_root.element("name");
			String name=doc_name.getText();
			  //方法2
			String CSDN= doc_root.elementText("CSDN"); 
			
			//取得属性
			String QQ=doc_name.attributeValue("QQ");
			
			
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
