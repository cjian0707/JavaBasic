package com.cjian.basicapi;

import java.io.IOException;
import java.util.Arrays;

/**
 * @Author: cjian
 * @Date: 2022/10/28 10:33
 * @Des:
 */
public class Arraycopy {
    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 6, 7, 8, 9};

        /**
         * arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
         * 第一个参数是要被复制的数组
         * 第二个参数是被复制的数组开始复制的下标
         * 第三个参数是目标数组，也就是要把数据放进来的数组
         * 第四个参数是从目标数组第几个下标开始放入数据
         * 第五个参数表示从被复制的数组中拿几个数值放到目标数组中
         */

        System.arraycopy(arr, 1, arr2, 0, 3);

        //234  89
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = new int[]{};
        arr3[0] = 1;
        arr3[1] = 2;
        arr3[2] = 3;
    }

}
