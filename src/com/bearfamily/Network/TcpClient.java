package com.bearfamily.Network;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {

        public static void main(String[] args) {
            InetAddress addr = InetAddress.getLoopbackAddress();

            BufferedWriter writer =null;
            BufferedReader reader =null;

            try {
                Socket socket = new Socket(addr,3610);

                //使用字符流包装字节流
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                writer.write("time\n");
                writer.flush();

                String serverRepsonse = reader.readLine();
                System.out.println(serverRepsonse);


            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }




        }
    }


