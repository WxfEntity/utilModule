package com.wxf.uitl.myTomcat;

/**
 * 解析xml所用的servlet
 * Created by wxf on 2018/2/2.
 */
public class XmlServlet {
    private String servlet_name;

    private String servlet_class;

    public String getServlet_name() {
        return servlet_name;
    }

    public void setServlet_name(String servlet_name) {
        this.servlet_name = servlet_name;
    }

    public String getServlet_class() {
        return servlet_class;
    }

    public void setServlet_class(String servlet_class) {
        this.servlet_class = servlet_class;
    }
}
