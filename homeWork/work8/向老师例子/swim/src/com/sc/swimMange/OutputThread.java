package com.sc.swimMange;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 放水线程
 * Created by captain on 2017/7/27.
 */
public class OutputThread implements Callable<Object>{

    private BlockingQueue<String> queue;

    public OutputThread(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public Object call() throws InterruptedException {
    	System.out.println("outputThread线程启动");
        while(true){
        	synchronized(queue)
        	{
        		 if(queue.size()==100){
                     break;
                 }
                 for(int cnt=0;cnt<3;cnt++){
                     queue.poll();
                 }
                 
        	}
        	System.out.println("放水3立方米，当前水量："+queue.size());
            TimeUnit.SECONDS.sleep(1);
        }
        return "OutputThread success";
    }
}
