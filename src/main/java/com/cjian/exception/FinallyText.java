package com.cjian.exception;

/**
 * @Author: cjian
 * @Date: 2022/11/7 14:23
 * @Des:
 */
public class FinallyText {
    public static void main(String[] args) {
        System.out.println(n());
    }

    public static int n() {
        int i = 100;
        try {
            return i;
        } finally {
            i++;
        }
    }
}
