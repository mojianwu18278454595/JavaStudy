/*
 * author: 沈翀
 * task: 完成 1万X1万 的举阵构造（个人电脑配置差，数量调低点）
 */

package myTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class data
{
	private int[][] myData;
	public int number;
	public int threads;
	
	public int[][] getMyData()
	{
		return myData;
	}
	
	public data()
	{
		//初始化时创建myData矩阵
		generateData();
	}
	
	//加载properties属性文件
	private int Number()
	{
		int number=0;
		Properties proper=new Properties();
		InputStream file=data.class.getResourceAsStream("/myTest/dataNumber.properties");
		try
		{
			proper.load(file);//加载属性文件
			file.close();
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//取出key——>value
		String n=proper.getProperty("number","1000");
		String t=proper.getProperty("threads","1");
		number=Integer.parseInt(n);
		threads=Integer.parseInt(t);
		myData=new int[number][number];
		this.number=number;
		return number;
	}
	
	//生成data数据
	private void generateData()
	{
		Random rand=new Random();
		int dt=rand.nextInt(100);
		
		int numbers=Number();
		for(int row=0;row<numbers;row++)
		{
			for(int clm=0;clm<numbers;clm++)
			{
				myData[row][clm]=dt;
				dt=rand.nextInt(100);
			}
		}
	}
	
	public static void main(String[] args)
	{
		data data=new data(); 
		System.out.println(data.number+","+data.threads);
	}

}
