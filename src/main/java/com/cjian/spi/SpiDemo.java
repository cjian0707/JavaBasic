package com.cjian.spi;

import java.util.ServiceLoader;

/**
 * @Author: cjian
 * @Date: 2022/10/26 16:00
 * @Des:
 */
public class SpiDemo {
    public static void main(String[] args) {
        ServiceLoader<CarService> load = ServiceLoader.load(CarService.class);
        for (CarService carService : load) {
            carService.run();
        }
    }
}
