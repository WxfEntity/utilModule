package com.wxf.uitl.concurrence;

import java.util.concurrent.TimeUnit;

/**
 * Created by wxf on 2018/2/24.
 */
public class InterruputThread {
    //未改进版
  /*  public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(){
            @Override
            public void run(){
                while(true){
                    System.out.println("未被中断");
                }
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();
    }*/
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(){
            @Override
            public void run(){
                while(true){
                    if(this.isInterrupted()){
                        System.out.println("线程中断");
                        break;
                    }
                    System.out.println("未被中断");
                }
                System.out.println("已跳出循环，线程中断");
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();
    }
}
