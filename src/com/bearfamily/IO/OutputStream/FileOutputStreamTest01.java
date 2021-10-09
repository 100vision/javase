package com.bearfamily.IO.OutputStream;

//FileOutputStream类，文件输出字节流，从内存输出到硬盘
//本例中：使用把一个内存字符变量输出到文件

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest01 {

    public static void main(String[] args) {

        FileOutputStream fos = null;

        {
            try {

                fos = new FileOutputStream("IOFileOutputStream.txt");
                String content = "这是通过FileOutputStream字节流输出内存变量内容到该文件";
                fos.write(content.getBytes());
                

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (fos!= null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }







}
