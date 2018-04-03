package com.wxf.uitl.designMolde.VisitorPattern;

/**
 * Created by wxf on 2018/4/3.
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);

}
