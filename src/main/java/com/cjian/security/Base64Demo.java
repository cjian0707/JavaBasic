package com.cjian.security;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.SecureRandom;

/**
 * @Author: cjian
 * @Date: 2022/11/9 17:09
 * @Des:
 */
public class Base64Demo {
    public static Base64 base64 = new Base64();
    public static SecureRandom secureRandom = new SecureRandom();

    public static void main(String[] args) {
        String man = base64.encode("you".getBytes());
        System.out.println("you的base64结果："+man);

        byte[] randomBytes = new byte[16];
        secureRandom.nextBytes(randomBytes);

        String str = new String(randomBytes);
        System.out.println("原值：" + str);
        //问题来了，长度发生了变化
        //如果转string和获取字节的时候指定ISO-8859-1就没有问题
        System.out.println("原值转byte长度:"+str.getBytes().length);

        String r = base64.encode(randomBytes);
        System.out.println("base64后：" + r);

        String str2 = new String(base64.decode(r));
        System.out.println("base64编码:" + str2);
        System.out.println("base64解码后byte长度：" + base64.decode(r).length);

    }

}
