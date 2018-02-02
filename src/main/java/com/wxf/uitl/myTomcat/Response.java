package com.wxf.uitl.myTomcat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

/**
 * Created by wxf on 2018/2/1.
 */
public class Response {
    private static final String ENTER = "\r\n";
    private static final String SPACE = " ";
    //存储头信息
    private StringBuilder headerInfo ;
    //2、存储正文信息
    private StringBuilder textContent;
    //3、记录正文信息长度
    private int contentLength ;

    //4、构建输出流
    private BufferedWriter bw ;
    public Response() {
        headerInfo = new StringBuilder();
        textContent =  new StringBuilder();
        contentLength = 0;
    }

    public Response(OutputStream os) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    /**
     * 创建消息头
     * @param code
     */
    private void createHeader(int code){
        headerInfo.append("HTTP/1.1").append(SPACE).append(code).append(SPACE);
        switch (code){
            case 200:
                headerInfo.append("Ok").append(ENTER);
                break;
            case 404:
                headerInfo.append("NOT FOUND").append(ENTER);
                break;
            case 500:
                headerInfo.append("SERVER ERROR").append(ENTER);
                break;
            default:
                break;
        }
        headerInfo.append("Server:myServer").append(SPACE).append("0.0.1v").append(ENTER);
        headerInfo.append("Date:Sat,"+SPACE).append(new Date()).append(ENTER);
        headerInfo.append("Content-Type:text/html;charset=UTF-8").append(ENTER);
        headerInfo.append("Content-Length:").append(contentLength).append(ENTER);
        headerInfo.append(ENTER);
    }

    /**
     * 响应给浏览器解析的内容(html正文)
     * @param content
     * @return
     */
    public Response htmlContent(String content){
        textContent.append(content).append(ENTER);
        contentLength+= (content+ENTER).toString().getBytes().length;
        return this;
    }

    /**
     * 发送给浏览器端
     * @param code
     */
    public void pushToClient(int code){
        createHeader(code);
        try {
            bw.append(headerInfo.toString());
            System.out.println(headerInfo.toString());
            bw.append(textContent.toString());
            System.out.println(textContent.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
