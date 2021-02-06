package com.bearfamily.DateTime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeOperation {

    public static void main(String[] args) {

        /*
        新API的方法:locatdate, localTime,LocaltDateTime, DateTimeFormatter
         */
        //获取当前系统时间
        System.out.println("当前系统时钟是 " + LocalDateTime.now());
        System.out.println("当前系统时钟的30天后是 " + LocalDateTime.now().plusDays(30));
        System.out.println("当前系统时钟的6个小时前是 " + LocalDateTime.now().minusHours(6));



        //获取当前日期
        System.out.println("当前系统日期是 " + LocalDate.now());

        //获取当前时间
        System.out.println("当前系统时间是 " + LocalTime.now());

        //日期自定义格式化，例如DateTimeFormatter.ofPattern("yyyy-MM-dd hh:MM:ss");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:MM:ss");
        System.out.println("当前系统时钟默认是使用ISO-8601格式，例如日期和时间：yyyy-MM-dd'T'HH:mm:ss，可以格式化成 \n：" + formatter.format(LocalDateTime.now()));


    }
}
