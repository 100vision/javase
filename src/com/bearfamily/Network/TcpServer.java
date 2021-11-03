package com.bearfamily.Network;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.util.Date;

public class TcpServer {

    public static void main(String[] args) {

        // write your code here
        try {

            ServerSocket ss = new ServerSocket(3610);
            System.out.println("Server is ready!\n");

            Socket socket = ss.accept();

            BufferedReader reader =null;
            BufferedWriter writer =null;


            try {

                //使用字符流包装字节流。可以直接读写字符
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String response = reader.readLine();

                if ("time".equals(response)) {
                    writer.write(LocalDateTime.now().toString() + "\n");
                    writer.flush();
                } else {
                    writer.write("invalid\n");
                }

            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                reader.close();
                writer.close();
            }



            ss.close();
            socket.close();











        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
