package com.bearfamily.IO.InputStream;


// FileInputStream 文件字节流，注意是字节流，不是字符流。从硬盘读入到内存，input, 如果所内存到硬盘，是输出output
// 以reader或是writer结尾的是字符流

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {

        FileInputStream fs = null;

        //定义一个数组作为缓冲来提高读效率，而不是一个一个字节读取。
        //举例：以下是一个8字节的数组
        byte[] bytes = new byte[8];

        try {
            File file = new File("IOFileInputSteamTest1");
            fs = new FileInputStream(file);

            //定义一次读取的字节数
            int readSize = 0;

            //读取文件输入流不为-1，-1代表字节流已经空了，读到了文件末尾。
            while ((readSize = fs.read(bytes)) != -1) {
                //System.out.println(fs.read(bytes,0,readCount));
                String content = new String(bytes, 0, readSize);
                System.out.println(content);


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fs == null) {
                fs.close();
            }


        }
    }
}

