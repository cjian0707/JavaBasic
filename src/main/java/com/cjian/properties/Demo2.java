package com.cjian.properties;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * @Author: cjian
 * @Date: 2022/11/2 17:11
 * @Des:
 */
public class Demo2 {
    public static void main(String[] args) {
        System.out.println(getValue("com.cjian.name"));
        System.out.println(getValue("com.cjian.age"));
        setValue("com.cjian.name", "cjian21");
        setValue("com.cjian.age", "2881");
        System.out.println("-->"+getValue("com.cjian.name"));
        System.out.println("-->"+getValue("com.cjian.age"));

    }

    private static String getValue(String key) {
        Properties p = new Properties();
        String value = null;
        try {
            //非实时动态获取
            //p.load(new InputStreamReader(this.class.getClassLoader().getResourceAsStream(filePath), "UTF-8"));
            //下面为动态获取
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            InputStream is = Demo2.class.getClassLoader().getResourceAsStream("test.properties");
            p.load(is);
            Iterator<Map.Entry<Object, Object>> iterator = p.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Object, Object> next = iterator.next();
                System.out.println(next.getKey() + "=" + next.getValue());
            }
            value = p.getProperty(key);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    private static void setValue(String key, String value) {
        Properties p = new Properties();
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        FileOutputStream oFile = null;
        try {
            InputStream is = new FileInputStream(path + File.separator + "test.properties");
            p.load(is);
            oFile = new FileOutputStream(path + File.separator + "test.properties");
            p.setProperty(key, value);
            //将Properties中的属性列表（键和元素对）写入输出流
            p.store(oFile, "");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
