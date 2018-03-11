package com.subin.framework.pattern.factory.simple;

import com.subin.framework.pattern.factory.Audi;
import com.subin.framework.pattern.factory.Benz;
import com.subin.framework.pattern.factory.Bmw;
import com.subin.framework.pattern.factory.Car;

/**
 * @author: subiin
 * @date: 2018/2/3 下午5:26
 * @description:
 */
public class SimpleFactory {

    public Car getCar(String name) {
        if ("BMW".equalsIgnoreCase(name)) {
            return new Bmw();
        } else if ("Benz".equalsIgnoreCase(name)) {
            return new Benz();
        } else if ("Audi".equalsIgnoreCase(name)) {
            return new Audi();
        } else {
            System.out.println("这个产品产不出来");
            return null;
        }
    }
}
