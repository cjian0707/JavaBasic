package com.cjian.spi;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.ServiceLoader;

/**
 * @Author: cjian
 * @Date: 2022/10/26 16:00
 * @Des:
 */
public class SpiDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ServiceLoader<CarService> load = ServiceLoader.load(CarService.class);
        for (CarService carService : load) {
            carService.run();
        }
        System.out.println(128 >> 3);
        System.out.println(16&7);


    }
}
