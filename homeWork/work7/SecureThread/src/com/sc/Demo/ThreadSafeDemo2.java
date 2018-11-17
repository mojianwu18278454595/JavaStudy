package com.sc.Demo;

import java.util.List;
import java.util.Random;

/**
 * 线程安全演示类
 * Created by captain on 2017/7/27.
 */
public class ThreadSafeDemo2 implements Runnable{

    private List<String> list;

    public ThreadSafeDemo2(List<String> list){
        this.list = list;
    }

    @Override
    public void run() {
    	
        System.out.println("线程22");
    //synchronized(this.list){
        while(list.size()<100){
        	try
			{
				Thread.sleep(10); 
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 synchronized(this.list){
            list.add("版权归作者所有");
            System.out.println("添加一个后尺寸："+list.size());
        }
    }
    }
}
