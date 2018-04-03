package com.wxf.uitl.designMolde.PrototypePattern;

/**
 * Created by wxf on 2018/3/27.
 */
public class Circle extends Shape {
    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
