package com.wxf.uitl.designMolde.PrototypePattern;

/**
 * Created by wxf on 2018/3/27.
 */
public class Square extends Shape {
    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

}

