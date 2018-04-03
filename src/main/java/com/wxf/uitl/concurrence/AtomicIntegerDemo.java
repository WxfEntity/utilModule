package com.wxf.uitl.concurrence;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wxf on 2018/2/27.
 */
public class AtomicIntegerDemo {
    static AtomicInteger atomicInteger = new AtomicInteger();
    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10000;i++){
                atomicInteger.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int k = 0;k<10;k++){
            threads[k] = new Thread(new AddThread());
        }
        for(int k = 0;k<10;k++){
            threads[k].start();
        }
        for(int k = 0;k<10;k++){
            threads[k].join();
        }
        System.out.println(atomicInteger);
    }
}
