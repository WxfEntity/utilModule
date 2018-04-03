package com.wxf.uitl.designMolde.builderPattern;

/**
 * Created by wxf on 2018/3/27.
 */
public class ChickenBurger extends Burger{
    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
