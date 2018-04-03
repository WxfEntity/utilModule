package com.wxf.uitl.designMolde.Bridge;

/**
 * Created by wxf on 2018/4/2.
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
