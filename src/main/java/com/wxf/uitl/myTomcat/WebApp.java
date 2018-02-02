package com.wxf.uitl.myTomcat;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by wxf on 2018/2/2.
 */
public class WebApp {
    private static ServletContext context;
    static {
        context = new ServletContext();
        //创建存放上下文的容器
        Map<String,String> mapping = context.getMapping();
        Map<String,String> servlet = context.getServlet();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            //2、从解析工程获取解析器
            SAXParser parser = factory.newSAXParser();
            //3、加载文档并注册处理器（handle）。注意：此处的文档可以用file的形式也可以用流的形式，随便,便于学习，下面提供两种。
            //String filePath = "";
            //parser.parse(new File(filePath), handler);
            XMLHandler handler = new XMLHandler();
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/wxf/uitl/myTomcat/web.xml");
            parser.parse(is, handler);

            List<XmlServlet> serv = handler.getServlet();
            for (XmlServlet xmlServlet : serv) {
                servlet.put(xmlServlet.getServlet_name(), xmlServlet.getServlet_class());
            }
            List<XmlMapping> map = handler.getMapping();
            for (XmlMapping maps : map) {
                List<String> actions = maps.getUrl_pattern();
                for (String action : actions) {
                    mapping.put(action, maps.getServlet_name());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
    public static Servlet getServlet(String action){
        if("".equals(action) || action == null){
            return null;
        }
        //通过action找到servlet-name
        String servlet_name = context.getMapping().get(action);
        //通过反射，找到相应的类，创建其对象并返回
        String classPath =  context.getServlet().get(servlet_name);//通过action得到类路径

        Servlet servlet = null;
        if(classPath != null){
            Class<?> clazz = null;
            try {
                clazz = Class.forName(classPath);
                servlet = (Servlet)clazz.newInstance();//要确保空构造存在
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return servlet;
    }
}
