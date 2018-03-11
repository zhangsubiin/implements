package com.subin.framework.pattern.factory.func;

import com.subin.framework.pattern.factory.Benz;
import com.subin.framework.pattern.factory.Car;

/**
 * @author: subiin
 * @date: 2018/2/4 上午11:35
 * @description:
 */
public class BenzFactory implements Factory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
