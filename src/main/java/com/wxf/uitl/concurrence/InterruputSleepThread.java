package com.wxf.uitl.concurrence;

import java.util.concurrent.TimeUnit;

/**
 * Created by wxf on 2018/2/24.
 * 线程中断与synchronized
 */
public class InterruputSleepThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
          @Override
          public void run(){
              //while在try中，通过异常中断就可以退出run循环
            try {

                while (true){
                    //while在try中，通过异常中断就可以退出run循环
                    TimeUnit.SECONDS.sleep(2);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Interruted When Sleep");
                boolean interrupt = this.isInterrupted();
                //中断状态被复位
                System.out.println("interrupt:"+interrupt);
            }
          }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        //中断处于阻塞状态的线程
        t1.interrupt();
    }
}
