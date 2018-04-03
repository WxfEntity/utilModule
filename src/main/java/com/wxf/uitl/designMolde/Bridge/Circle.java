package com.wxf.uitl.designMolde.Bridge;

/**
 * Created by wxf on 2018/4/2.
 */
public class Circle extends Shape{
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {

    }
}
