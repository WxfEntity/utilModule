package com.wxf.uitl.concurrence;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by wxf on 2018/2/27.
 */
public class AtomicIntegerArrayDemo {
    static AtomicIntegerArray arr = new AtomicIntegerArray(10);
    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for(int k = 0;k<10000;k++){
                arr.getAndIncrement(k%arr.length());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int k=0;k<10;k++){
            threads[k]=new Thread(new AddThread());
        }
        //启动10条线程
        for(int k=0;k<10;k++){threads[k].start();}
        for(int k=0;k<10;k++){threads[k].join();}
        System.out.println(arr);
    }
}
