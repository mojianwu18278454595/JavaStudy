/*
 * Athor：沈翀
 * Task：总测试
 * Result:思路失败，总结测试说明文档
 */

package myTest;

import java.util.ArrayList;
import java.util.Calendar;

public class test
{
	public static void runThreads()
	{
		new arithmetic().start();
		new arithmeticSec().start();
		new arithmeticThird().start();
		
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		//准备工作
		int threads=1; //默认线程数为1
		ArrayList<arithmetic> list=new ArrayList<arithmetic>();
		arithmetic atc=new arithmetic();
		threads=atc.getThreads(); //取得设置的线程数
		
		/*
		 * 提前测试实验
		 */
		arithmetic ar1=new arithmetic();
		arithmetic ar11=new arithmetic();
		arithmetic ar12=new arithmetic();
		arithmeticSec ar2=new arithmeticSec();
		arithmeticThird ar3=new arithmeticThird();
		Calendar can=Calendar.getInstance();
		long begin=can.getTimeInMillis();
		
		ar1.start();
		ar12.start();
		ar11.start();
		ar1.join();
		ar12.join();
		ar11.join();
			
		Calendar can1=Calendar.getInstance();	
		long end=can1.getTimeInMillis();
		
		/*
		 * 正式测试:方法失败
		 */	
		//准备线程运算对象
//		for(int i=0;i<threads;i++)
//		{
//			list.add(new arithmetic());
//		}
//		Calendar can=Calendar.getInstance();
//		long begin=can.getTimeInMillis();
//		
//		for(int i=0;i<threads;i++)
//		{
//			list.get(i).start();
////			if(i==0)
////				ar1.start();
////			if(i==1)
////				ar2.start();
////			if(i==2)
////				ar3.start();
//		}
//			
//		for(int i=0;i<threads;i++)
//		{
//			list.get(i).join();
////			if(i==0)
////				ar1.join();
////			if(i==1)
////				ar2.join();
////			if(i==2)
////				ar3.join();
//		}
//		
//		Calendar can1=Calendar.getInstance();	
//		long end=can1.getTimeInMillis();
		System.out.println("(当前总线程数为："+threads+",矩阵运算总时长为："+(int)(end-begin)+")");
	}
}
