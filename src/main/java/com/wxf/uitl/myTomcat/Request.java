package com.wxf.uitl.myTomcat;

import java.io.*;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wxf on 2018/2/2.
 */
public class Request {
    private static final String ENTER = "\r\n";
    //接受请求
    private BufferedReader request;
    //接受储存信息
    private String requestHeader;
    //通过解析消息头得到请求方法
    private String method;
    //通过解析消息头得到请求的url
    private String action;
    //通过解析消息头得到传过来的参数，可能存在一个key对应多个value的情况，所以用list
    private Map<String,List<String>> paramter;

    public Request() {
        requestHeader="";
        method="";
        paramter = new HashMap<String,List<String>>();
    }
    public Request(InputStream inputStream){
        this();
        request = new BufferedReader(new InputStreamReader(inputStream));
        //接收到头部消息
        try {
            String temp;
            while(!(temp=request.readLine()).equals("")){
                requestHeader +=(temp+ENTER);
            }
            System.out.println(requestHeader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        parseRequestHeader();
    }

    /**
     * 解析消息头
     */
    private void parseRequestHeader() {
        //声明一个字符串，来存放请求参数
        String parameterString = "";
        //读取消息头的第一行
        String firstLine = requestHeader.substring(0,requestHeader.indexOf(ENTER));
        //开始分离第一行
        //splitPoint 分割点1
        int splitPointOne = firstLine.indexOf("/");
        method = firstLine.substring(0,splitPointOne).trim();
        //splitPoint 分割点2
        int splitPointTwo = firstLine.indexOf("HTTP/");
        String actionTemp = firstLine.substring(0,splitPointTwo).trim();
        if(method.equalsIgnoreCase("post")){
            this.action = actionTemp;
        }else if(method.equalsIgnoreCase("get")){
            if(actionTemp.contains("?")){
                parameterString = actionTemp.substring(actionTemp.indexOf("?")+1).toString();
                this.action = actionTemp.substring(0,actionTemp.indexOf("?"));
            }else{
                this.action = actionTemp;
            }
        }
        //将参数封装到Map中
        parseParameterString(parameterString);
    }

    /**
     * 解析参数字符串，封装到Map中
     * @param paramterString
     */
    private void parseParameterString(String paramterString) {
        if("".equals(paramterString)){
            return;
        }else {
            String[] parameterKeyValues = paramterString.split("&");
            for(int i=0;i<parameterKeyValues.length;i++){
                String[] keyValue = parameterKeyValues[i].split("=");
                if(keyValue.length==1){
                    keyValue = Arrays.copyOf(keyValue,2);
                    keyValue[1] = null;
                }
                String key = keyValue[0].trim();
                String values = null==keyValue[1]?null:decode(keyValue[1].toString(),"utf-8");
                if(!paramter.containsKey(key)){
                    paramter.containsKey(key);
                }
                List<String> value = paramter.get(key);
                value.add(values);
            }

        }
    }

    /**
     * 反解码 使用指定的编码机制对 application/x-www-form-urlencoded 字符串解码。
     * @param string
     * @param encoding
     * @return
     */
    public String decode(String string, String encoding) {
        try {
            return URLDecoder.decode(string, encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 根据名字得到多个值
     * @param name
     * @return
     */
    public String[] getParamterValues(String name){
        List<String> values = paramter.get(name);
        if(values == null){
            return null;
        }else{
            return values.toArray(new String[0]);
        }
    }
    /**
     * 根据名字返回单个值
     * @param name
     * @return
     */
    public String getParamter(String name){
        String[] value = getParamterValues(name);
        if(value == null){
            return null;
        }else{
            return value[0];
        }
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
}
