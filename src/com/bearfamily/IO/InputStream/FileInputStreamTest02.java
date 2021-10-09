package com.bearfamily.IO.InputStream;

import java.io.FileInputStream;

public class FileInputStreamTest02 {

    public static void main(String[] args){
        String content=null;
        try {
            int size=0;
            //定义一个字节缓冲区,该缓冲区的大小根据需要来定义
            byte[] buffer=new byte[1024];
            FileInputStream fis=new FileInputStream("FOSDemo.txt");
            //循环来读取该文件中的数据
            while((size=fis.read(buffer))!=-1){
                content=new String(buffer, 0, size);
                System.out.println(content);
            }
            //关闭此文件输入流并释放与此流有关的所有系统资源。
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
