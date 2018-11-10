package myTest;

import java.util.Calendar;

public class arithmeticSec extends Thread
{
	private int[][] data1;
	private int[][] data2;
	private int threads;
	private int rows;
	private int clms;
	public long time;
	
	public int getThreads()
	{
		return this.threads;
	}
	
	public arithmeticSec()
	{
		getFormData();
	}
	
	//创建两个矩阵
	private void getFormData()
	{
		data d1=new data();
		data d2=new data();
		this.threads=d1.threads;
		this.rows=d1.number/d1.threads;
		this.clms=d1.number;
		data1=new int[d1.number][d1.number];
		data2=new int[d2.number][d2.number];
		data1=d1.getMyData();
		data2=d2.getMyData();
	}
	
	@Override
	public void run()
	{
		try
		{
			//Thread.sleep(10);//sleep 10ms
			
			//矩阵运算
			
			for(int i=this.rows;i<2*this.rows;i++)
			{
				System.out.println("线程2启动！");
				for(int row=0;row<this.clms;row++)
				{
					for(int clm=0;clm<this.clms;clm++)
					{
						int a=data1[i][clm]*data2[clm][row];
					}
				}
			}
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	//多线程分配运算
	public void myArithmetic()
	{
		//矩阵运算
		for(int i=0;i<this.rows;i++)
		{
			for(int row=0;row<this.clms;row++)
			{
				for(int clm=0;clm<this.clms;clm++)
				{
					int a=data1[i][clm]*data2[clm][row];
				}
			}
		}
	}

	public static void main(String[] args)
	{
		arithmeticSec atc1=new arithmeticSec();
		Calendar can=Calendar.getInstance();
		long begin=can.getTimeInMillis();
		
		atc1.myArithmetic();
		
		Calendar can1=Calendar.getInstance();
		long end=can1.getTimeInMillis();
		
		System.out.println((int)(end-begin));


	}

}
