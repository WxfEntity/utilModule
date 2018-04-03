package com.wxf.uitl.designMolde.VisitorPattern;

/**
 * Created by wxf on 2018/4/3.
 */
public class Keyboard implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
