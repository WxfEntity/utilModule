package com.wxf.uitl.concurrence;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by wxf on 2018/2/27.
 */
public class AtomicIntegerFieldUpdaterDemo {
    public static class Candidates{
        int id ;
        volatile int score;
    }
    public int num=0;
    public static class Game{
        int id;
        volatile String name;

        public Game(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Game{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    static AtomicIntegerFieldUpdater<Candidates> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidates.class,"score");
    static AtomicReferenceFieldUpdater<Game,String> atRefUpdate = AtomicReferenceFieldUpdater.newUpdater(Game.class,String.class,"name");
    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final Candidates candidates = new Candidates();
        Thread[] threads = new Thread[10000];
        //开启10000个线程
        for(int i = 0;i<10000;i++){
            threads[i] = new Thread(){
              public void run(){
                  if(Math.random()>0.4){
                        atomicIntegerFieldUpdater.incrementAndGet(candidates);
                        atomicInteger.incrementAndGet();
                  }
              }
            };
            threads[i].start();
        }
        for(int i = 0;i<10000;i++){
            threads[i].join();
        }
        System.out.println("最终分数:"+candidates.score);
        System.out.println("校验分数:"+atomicInteger);

        //AtomicReferenceFieldUpdater 简单的使用
        Game game = new Game(2,"zh");
        atRefUpdate.compareAndSet(game,game.name,"JAVA-HHH");
        System.out.println(game.toString());

    }
}
