package com.cjian.properties;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @Author: cjian
 * @Date: 2022/10/18 15:36
 * @Des:
 */
public class Demo {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        //properties.list(System.out);
        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String strKey = (String) enumeration.nextElement();
            String strValue = properties.getProperty(strKey);
            System.out.println(strKey + "," + strValue);
        }
        properties.keySet();

    }
}
