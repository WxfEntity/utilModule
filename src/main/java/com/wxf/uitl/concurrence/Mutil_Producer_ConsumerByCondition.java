package com.wxf.uitl.concurrence;

/**
 * Created by wxf on 2018/3/1.
 */
public class Mutil_Producer_ConsumerByCondition {
    public static void main(String[] args) {
        ResourceByCondition resourceByCondition = new ResourceByCondition();
        Mutil_Producer pro = new Mutil_Producer(resourceByCondition);
        Mutil_Consumer con = new Mutil_Consumer(resourceByCondition);
        //生产者线程
        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);
        //启动线程
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
class Mutil_Producer  implements Runnable{
    private ResourceByCondition r;

    public Mutil_Producer(ResourceByCondition r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true){
            r.product("北京烤鸭");
        }
    }
}
class Mutil_Consumer  implements Runnable{
    private  ResourceByCondition r;

    public Mutil_Consumer(ResourceByCondition r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.consumer();
        }
    }
}
