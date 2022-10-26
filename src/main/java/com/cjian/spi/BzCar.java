package com.cjian.spi;

/**
 * @Author: cjian
 * @Date: 2022/10/26 15:59
 * @Des:
 */
public class BzCar implements CarService {
    @Override
    public void run() {
        System.out.println("BZ run ...");
    }
}
