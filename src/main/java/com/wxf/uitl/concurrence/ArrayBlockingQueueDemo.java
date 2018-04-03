package com.wxf.uitl.concurrence;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by wxf on 2018/3/6.
 */
public class ArrayBlockingQueueDemo {
    private final static ArrayBlockingQueue<Apple> QUEUE = new ArrayBlockingQueue<Apple>(1);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Producer(QUEUE));
        Thread t2 = new Thread(new Producer(QUEUE));
        Thread t3 = new Thread(new Consumer(QUEUE));
        Thread t4 = new Thread(new Consumer(QUEUE));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Apple{
    public Apple(){

    }
}

/**
 * 生产者线程
 */
class Producer implements Runnable{
    private final ArrayBlockingQueue<Apple> mApp;

    Producer(ArrayBlockingQueue<Apple> mApp) {
        this.mApp = mApp;
    }

    @Override
    public void run() {
        while (true){
            Produce();
        }
    }
    private void Produce(){
        try {
            Apple apple = new Apple();
            mApp.put(apple);
            System.out.println("生产:"+apple);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Consumer implements Runnable{
    private final ArrayBlockingQueue<Apple> mApp;

    Consumer(ArrayBlockingQueue<Apple> mApp) {
        this.mApp = mApp;
    }

    @Override
    public void run() {
            while (true){
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    comsume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
    private void comsume() throws InterruptedException {
        Apple apple = mApp.take();
        System.out.println("消费Apple="+apple);
    }
}