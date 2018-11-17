//package com.sc.Demo;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
///**
// * 线程安全演示类
// * Created by captain on 2017/7/27.
// */
//public class thread implements Runnable{
//
//    
//
//    public thread(List<String> list){
//    	
//        ThreadSafeDemo1.list = list;
//    }
//
//    @Override
//    public void run() {
//        Random random = new Random();
//        System.out.println("线程2："+ random.nextInt());
//       
//        //synchronized(this){
//             Iterator<String> iterator = ThreadSafeDemo1.list.iterator();
//            int cnt = 0;
//            while(iterator.hasNext()){
//            	synchronized(ThreadSafeDemo1.list){
//                iterator.next();
//                iterator.remove();
//                iterator = ThreadSafeDemo1.list.iterator();
//                cnt++;
//            	
//            	 try {
//                     TimeUnit.MILLISECONDS.sleep(10); 
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//            	}
//                System.out.println("222移除元素的数量："+cnt);
//            }
//           
//        }
//    //}
//}
