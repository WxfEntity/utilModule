package com.wxf.uitl.designMolde.builderPattern;

/**
 * Created by wxf on 2018/3/27.
 */
public class Coke extends ColdDrink{
    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
