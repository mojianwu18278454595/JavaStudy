package com.sc.Demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 线程安全演示类
 * Created by captain on 2017/7/27.
 */
public class ThreadSafeDemo1 implements Runnable{

    static List<String> list;
    static List<String> delList=new ArrayList<String>();

    public ThreadSafeDemo1(List<String> list){
    		this.list = list;     
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("线程："+ random.nextInt());
        Iterator<String> iterator;
        //synchronized(list) {
        		iterator = list.iterator();
                int cnt = 0;
                while(iterator.hasNext()){
                	synchronized(this.delList){
                		if(delList.size()<list.size())
                		{
                			delList.add( iterator.next());
                			cnt++;
                		}
                		else
                		{
                			
                			break;
                		}
                			
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                	}
                }
                delList.clear();
                System.out.println("移除元素的数量："+cnt);
        	}
     
       
    //}
}
