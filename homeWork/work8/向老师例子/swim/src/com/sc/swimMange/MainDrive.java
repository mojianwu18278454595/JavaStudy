package com.sc.swimMange;

import java.util.Calendar;
import java.util.Timer;
/**
 * Created by captain on 2017/7/27.
 */
public class MainDrive {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE),
                20,0,0
        );
        WaterTimeTask task = new WaterTimeTask();
        Timer timer = new Timer();
        //timer.schedule(task,calendar.getTime(),1000*60*60*24); //每天的20：00自动开始工作
        //测试版
        timer.schedule(task, 1000);
        System.out.println();
        System.out.println("主线程。。。。。。。");
    }
}
