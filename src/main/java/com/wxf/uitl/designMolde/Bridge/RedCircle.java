package com.wxf.uitl.designMolde.Bridge;

/**
 * Created by wxf on 2018/4/2.
 */
public class RedCircle implements DrawAPI{

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius +", x: " +x+", "+ y +"]");
    }
}
