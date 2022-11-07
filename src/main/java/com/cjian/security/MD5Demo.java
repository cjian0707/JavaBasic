package com.cjian.security;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * @Author: cjian
 * @Date: 2022/10/31 16:53
 * @Des: MD5测试
 */
public class MD5Demo {
    private static String CHARSET = "UTF-8";

    public static void main(String[] args) throws UnsupportedEncodingException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[16];
        secureRandom.nextBytes(randomBytes);
        System.out.println(new String(randomBytes, CHARSET));
        Base64 base64 = new Base64();

        String encode = base64.encode(randomBytes);
        System.out.println(encode);
        System.out.println(encode.length());
        System.out.println(new String(base64.decode(encode), CHARSET));
        System.out.println(base64.decode(encode).length);
        System.out.println(new String(base64.decode(encode), CHARSET));
        System.out.println("------------------");
        String s1 = new String(randomBytes, CHARSET);
        System.out.println(s1);
        byte[] bytes1 = s1.getBytes(CHARSET);
        System.out.println(new String(bytes1, CHARSET));
        System.out.println(bytes1.length);

        //生成的randomBytes可以通过对称加密存储起来
       /* String originalValue = new String(randomBytes) + "cjian";
        System.out.println("MD5加密后的字符串：" + setPassword(originalValue));

        String s = "123";
        byte[] bytes = s.getBytes();
        String s23 = "{AES}"+new String(bytes);
        System.out.println(s23);


        System.out.println("---------------------");
        String string = "{AES}123{IV}456";
        System.out.println(string.substring("{AES}".length(),string.indexOf("{IV}")));
        System.out.println(string.substring("{AES}".length(),string.indexOf("{IV}")));
        System.out.println(new String(string.getBytes()));*/


    }

    public static String setPassword(String str) {
        try {
            System.out.println("要加密的字符串：" + str);
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
