package com.wxf.uitl.designMolde.责任链Pattern;

/**
 * Created by wxf on 2018/4/3.
 */
public class FileLogger extends AbstractLogger{
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
