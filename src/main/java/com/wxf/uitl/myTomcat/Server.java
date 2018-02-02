package com.wxf.uitl.myTomcat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wxf on 2018/2/1.
 * 主程序端口，相当于Bootstrap
 */
public class Server {
    private boolean isShutDown = false;

    /**
     * 不指定端口就使用默认端口
     */
    public  void start(){
        start(8888);
    }

    public  void start(int port) {
        try {
            ServerSocket serverSocket  = new ServerSocket(port);
            this.receive(serverSocket);
        } catch (IOException e) {
            stop();
            e.printStackTrace();
        }
    }
    public void receive(ServerSocket serverSocket){
        try {
            while (!isShutDown){
                Socket client = serverSocket.accept();
                new Thread(new Dispatch(client)).start();
            }
        } catch (IOException e) {
            isShutDown=true;
            e.printStackTrace();
        }
    }
    public void stop(){
        isShutDown=true;
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
