package com.wxf.uitl.aspect;

/**
 * Created by wxf on 2018/1/11.
 */
public class HelloWord {
    public void sayHello(){
        System.out.println("hello world !");
    }
    public static void main(String args[]){
        HelloWord helloWord =new HelloWord();
        helloWord.sayHello();
    }
}
