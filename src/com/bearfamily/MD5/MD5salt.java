package com.bearfamily.MD5;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5salt {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String salt ="ThroneOfbean";
        String inputPassword="abcdefg123456";
        StringBuilder saltedPassword = new StringBuilder();
        saltedPassword.append(salt).append(inputPassword);
        System.out.println(saltedPassword);

        md.update(saltedPassword.toString().getBytes("UTF-8"));
        byte[] results = md.digest();
        System.out.println(new BigInteger(1,results).toString());


    }
}
