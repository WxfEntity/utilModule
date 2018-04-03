package com.wxf.uitl.designMolde.PrototypePattern;

/**
 * Created by wxf on 2018/3/27.
 */
public class Rectangle extends Shape {
    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
