package com.wxf.uitl.myTomcat;

/**
 * 抽象的servlet
 * Created by wxf on 2018/2/2.
 */
public abstract class Servlet {

    public void service(Request request, Response response) throws Exception {
        String method = request.getMethod();
        if(method.equalsIgnoreCase("post")){
            this.doPost(request, response);
        }else if(method.equalsIgnoreCase("get")){
            this.doGet(request, response);
        }
    }
    public void doGet(Request request, Response response) throws Exception{

    }

    public void doPost(Request request, Response response) throws Exception{

    }
}
