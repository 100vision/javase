package com.bearfamily.Networking.Socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",9999);
        try(InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream()){

            //调用外部方法来处理数据输入、输出流
            handleStream(input,output);

        }

        socket.close();
        System.out.println("disconneted.");

    }

    private static void handleStream(InputStream inputStream,OutputStream outputStream) throws IOException {

        //定义1个发送给服务器的输出流（通过字节流转换成缓冲输出流，一次性可以多发送)
        var writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

        //定义1个接收服务器的输入流（通过字节流转换成缓冲输出流，一次性可以多接收)
        var reader = new BufferedReader(new InputStreamReader(inputStream,StandardCharsets.UTF_8));

        //定义一个Scanner接收控制台输入，用来模拟发送数据给服务端
        Scanner userConsoleInput= new Scanner(System.in);

        System.out.println("[Server]" + reader.readLine());

        //开始发送和接收(同样需要循环，指定满足条件退出socket连接）
        for(;;) {
            System.out.println(">>> ");

            //读取一行用户控制台输入,并发送给服务器端
            String inputLine = userConsoleInput.nextLine();
            writer.write(inputLine);
            writer.newLine();
            writer.flush();

            //获取服务器的数据（响应）
            String responeLine = reader.readLine();
            if (responeLine.equals("bye")) {
                writer.write("bye \n");
                writer.flush();
                break;
            }


        }







    }



}
