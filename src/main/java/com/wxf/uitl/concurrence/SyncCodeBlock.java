package com.wxf.uitl.concurrence;

/**
 * Created by wxf on 2018/2/24.
 * 拿来反编译的
 */
public class SyncCodeBlock {
    public int i;

    public void syncTask(){
        synchronized (this){
            i++;
        }
    }
}
