
package com.sc.Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/11/16 
 * @author 沈翀 
 * CSDN https://blog.csdn.net/biggerchong
 * QQ 610254602
 */

public class ThreadMain {

    public static void main(String[] args) throws InterruptedException {
    	/**
    	 * test the Demo1 about serure thread
    	 */
        //第一个的演示示例
        List<String> list = new ArrayList<>();
        for(int cnt=0;cnt<100;cnt++){
            list.add("abc");
        }
        ThreadSafeDemo1 demo1 = new ThreadSafeDemo1(list);
        ThreadSafeDemo1 demo2 = new ThreadSafeDemo1(list);
        Thread thread1 = new Thread(demo1);
        Thread thread2 = new Thread(demo2);
        thread1.start();
        thread2.start();
       
       
        //第二个的演示示例
        /*List<String> list = new ArrayList<>();
        ThreadSafeDemo2 demo1 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo2 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo3 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo4 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo5 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo6 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo7 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo8 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo9 = new ThreadSafeDemo2(list);
        ThreadSafeDemo3 demo10 = new ThreadSafeDemo3(list);
        new Thread(demo1).start();
        new Thread(demo2).start();
        new Thread(demo3).start();
        new Thread(demo4).start();
        new Thread(demo5).start();
        new Thread(demo6).start();
        new Thread(demo7).start();
        new Thread(demo8).start();
        new Thread(demo9).start();
        new Thread(demo10).start();*/
    	
//    	//java移位测试
//    	int i=-10;
//    	i>>>=1;
//    	System.out.println("int -1:"+Integer.toBinaryString(-10)+","+Integer.toBinaryString(-10).length()+", -1>>>10:"+Integer.toBinaryString(i)+","+Integer.toBinaryString(i).length());
//    	
//    	long n=-10;
//    	n>>>=1;
//    	System.out.println("long -1:"+Long.toBinaryString(-10)+", -1>>>10:"+Long.toBinaryString(n));
    	
    }

}
