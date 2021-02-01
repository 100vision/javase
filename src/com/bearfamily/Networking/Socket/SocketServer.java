package com.bearfamily.Networking.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
/*
课程练习：
廖雪峰 - JAVA教程 ：Tcp编程
https://www.liaoxuefeng.com/wiki/1252599548343744/1305207629676577

 */

//服务器端类
public class SocketServer {
    public static void main(String[] args) throws IOException {
        //创建一个服务器socket并监听TCP 9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server is running on port 9999");

        //监听连接请求,需要不断循环
        for(;;){

            //开始接收连接请求
            Socket socket = serverSocket.accept();

            //打印出连接过来的客户端IP地址
            System.out.println("connected from "+socket.getRemoteSocketAddress());

            //主线程负责监听，另开启一个线程来负责处理socket中的数据流
            Thread t = new SocketThread(socket);

        }

    }
}

//处理socket中的数据流的线程类
class SocketThread extends Thread {
    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //获取网络输入流（从客户端接收 Inbound traffic）
        try(InputStream input = socket.getInputStream()){
            //获取网络输出流（发向客户端 Outbound traffic）
            try(OutputStream output = socket.getOutputStream()){
                handleStream(input,output);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("client disconnected");
    }

    private void handleStream(InputStream input, OutputStream output) throws IOException {
        var writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        var reader = new BufferedReader(new InputStreamReader(input,StandardCharsets.UTF_8));

        //Outbound: 发送数据到客户端。例如发送"hello"
        writer.write("Hello,Client\n");

        //立即刷新缓冲发送出去。这样不用缓冲满了再发送，
        writer.flush();

        //Inbound: 接收客户端。同样需要开启循环，不中断输入流接收数据。除非接收到客户端发来的特定，约定字符，例如"bye"。
        for(;;) {

            //开始从输入流(客户端）接收
            String inputLine = reader.readLine();

            //如果客户端发送”bye",则断开输入流并也发送bye给客户端
            if (inputLine.equals("bye")) {
                writer.write("bye\n");
                writer.flush();
                break;
            }

            writer.write("Server received this message: " +inputLine + "\n");
            writer.flush();
        }



    }
}
