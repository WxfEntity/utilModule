package com.wxf.uitl.designMolde.VisitorPattern;


/**
 * Created by wxf on 2018/4/3.
 */
public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
}
