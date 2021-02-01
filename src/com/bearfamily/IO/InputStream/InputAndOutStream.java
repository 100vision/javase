package com.bearfamily.IO.InputStream;

import java.io.*;

public class InputAndOutStream {
    public static void main(String[] args) throws IOException {


        try(java.io.InputStream input = new FileInputStream("src/readme.txt");
            OutputStream output= new FileOutputStream("src/readme.html");){

            //文件输入流直接转成输出流:即实现文件复制
            input.transferTo(output);
            output.flush();


        }





    }
}
