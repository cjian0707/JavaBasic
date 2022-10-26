package com.cjian.spi;

/**
 * @Author: cjian
 * @Date: 2022/10/26 15:59
 * @Des:
 */
public class BWMCar implements CarService {
    @Override
    public void run() {
        System.out.println("BWM run ...");
    }
}
