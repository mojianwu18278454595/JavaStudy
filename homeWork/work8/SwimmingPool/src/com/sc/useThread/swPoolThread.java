package com.sc.useThread;
/**
* @author 沈翀
* CSDN https://blog.csdn.net/biggerchong
* QQ 610254602
*/

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class swPoolThread
{
	public static Integer totalContent=10000;//总水量
	private static Integer myContent= 1000; //当前的水量
	private static Integer totalPop=0; //总出水量
	private static Integer totalIn=0;//总入水量
	static int time=0;
	//public synchronized pop
	
	
	private static class popSwim extends Thread
	{
		
		
		private AtomicInteger content;
		
		public popSwim(AtomicInteger content)
		{
			this.content=content;
		}
		
		@Override
		public void run()
		{
			System.out.println("popSwim启动");
			while(true)
			{
				
				
				synchronized(content)
				{
					if(content.get()==0)
					{
						try
						{
							content.wait();
						} catch (InterruptedException e)
						{
						}
					}
					
					if(myContent.equals(totalContent))
						break;
					if(content.get()==1)
					{
						
						totalPop=totalPop+3;
						myContent-=3;
						time++;
						System.out.println("当前共排出"+totalPop+"L水,当前水量"
								+myContent+",当前耗时"+time/2+"s");
						content.set(0);
						content.notify();
					}
					
				}
			}
			
		}
		
	}
	
	private static class inSwim extends Thread
	{

		private AtomicInteger content;
		
		public inSwim(AtomicInteger content)
		{
			this.content=content;
		}
		
		@Override
		public void run()
		{
			System.out.println("inSwim启动");
			while(true)
			{
				
			
				synchronized(content)
				{
					if(content.get()==1)
					{
						try
						{
							content.wait();
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					if(myContent.equals(totalContent))
						break;
					
					if(content.get()==0)
					{
						totalIn=totalIn+5;
						myContent+=5;
						time++;
						System.out.println("当前共注入"+totalIn+"L水,当前水量"
								+myContent+",当前耗时"+time/2+"s");
						content.set(1);
						content.notify();
					
					}
					
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		System.out.println("-------当池中剩余"+myContent+"L水时--------");
		AtomicInteger content=new AtomicInteger(1);
		//启动线程
		inSwim in=new inSwim(content);
		
		popSwim pop=new popSwim(content);
		
		in.start();
		pop.start();
		
		
		TimeUnit.MILLISECONDS.sleep(1500);
		
		System.out.println("----------换水总耗时为:"+time/2+"s----------");
		
	}
	
	
}
