package com.wxf.uitl.myTomcat;

import java.io.IOException;
import java.net.Socket;

/**
 * 分发请求
 * Created by wxf on 2018/2/2.
 */
public class Dispatch implements Runnable{
    private Socket client;
    private Request request;
    private Response response;
    private int code = 200;

    public Dispatch(Socket client) {
        this.client = client;
        try {
            request  =new Request(client.getInputStream());
            response = new Response(client.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
            code = 500;
            return;
        }
    }
    //重写
    @Override
    public void run() {
        try{
            String action = request.getAction();
            Servlet servlet = WebApp.getServlet(action);
            if(servlet == null){
                this.code = 404;
                response.pushToClient(code);
                return;
            }
            servlet.service(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            code = 500;
        }
        response.pushToClient(code);
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
