package com.wxf.uitl.designMolde.责任链Pattern;

/**
 * Created by wxf on 2018/4/3.
 */
public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error  Console::Logger: " + message);
    }
}
