package com.wxf.uitl.designMolde.builderPattern;

/**
 * Created by wxf on 2018/3/27.
 */
public class VegBurger extends Burger{
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
