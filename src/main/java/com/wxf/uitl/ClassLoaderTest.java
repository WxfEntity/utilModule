package com.wxf.uitl;

import com.wxf.uitl.classloader.FileClassLoader;

/**
 * Created by TYZ027 on 2018/1/9.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        String rootDir="/Users/zejian/Downloads/Java8_Action/src/main/java/";
        FileClassLoader loader1 = new FileClassLoader(rootDir);

        System.out.println("自定义类加载器的父加载器: "+loader1.getParent());
        System.out.println("系统默认的AppClassLoader: "+ClassLoader.getSystemClassLoader());
        System.out.println("AppClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent());
        System.out.println("ExtClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent().getParent());
    }
}
