package com.wxf.uitl.designMolde.VisitorPattern;

/**
 * Created by wxf on 2018/4/3.
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {

        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
