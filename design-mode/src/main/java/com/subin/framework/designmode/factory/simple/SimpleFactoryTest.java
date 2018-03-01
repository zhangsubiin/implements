package com.subin.framework.designmode.factory.simple;

import com.subin.framework.designmode.factory.Car;

/**
 * @author: subiin
 * @date: 2018/2/3 下午5:28
 * @description:
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        //这边就是我们的消费者
        Car car = new SimpleFactory().getCar("Audi");
        System.out.println(car.getName());
    }
}
