package com.wxf.uitl;

/**
 * Created by TYZ027 on 2017/12/19.
 */
public class newCallValue {
    public  void updateValue(int value){
        value = 3 * value;
    }

    public static void main(String[] args) {
        ClassLoader.getSystemClassLoader();
        int x= 10;
        System.out.println("赋值前："+x);
        newCallValue newCallValue = new newCallValue();
        newCallValue.updateValue(10);
        System.out.println("赋值后："+x);
    }
}
