package com.bearfamily.String;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StringBuilderTest01 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append(LocalDateTime.now()).append("����ʱ��");
        System.out.println(sb);
    }


}
