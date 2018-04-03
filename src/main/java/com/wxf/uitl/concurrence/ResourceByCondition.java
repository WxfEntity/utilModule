package com.wxf.uitl.concurrence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wxf on 2018/3/1.
 */
public class ResourceByCondition {
    private String name;
    private int count = 1;
    private boolean flag = false;
    //创建一个锁对象
    Lock lock = new ReentrantLock();
    //通过已有的锁对象获取两组监视器，一组监视生产者，一组见识消费者。
    Condition producer_con  = lock.newCondition();
    Condition consumer_con  = lock.newCondition();

    /**
     * 生产烤鸭
     * @param name
     */
    public void product(String name){
        lock.lock();
        try {
            while (flag){
                try {
                    producer_con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name+count;
            count++;
            System.out.println(Thread.currentThread().getName()+"生产者5.0..."+this.name);
            flag = true;
            consumer_con.signal();
        }finally {
            lock.unlock();
        }
    }

    public void consumer(){
        lock.lock();
        try {
            while (!flag){
                try {
                    consumer_con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"消费者.5.0..."+this.name);
            flag = false;
            consumer_con.signal();
        }finally {
            lock.unlock();
        }
    }
}
