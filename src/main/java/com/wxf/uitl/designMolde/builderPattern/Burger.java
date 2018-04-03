package com.wxf.uitl.designMolde.builderPattern;

/**
 * Created by wxf on 2018/3/27.
 */
public abstract class Burger implements Item{
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
