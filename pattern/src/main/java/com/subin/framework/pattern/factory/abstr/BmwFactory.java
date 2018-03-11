package com.subin.framework.pattern.factory.abstr;

import com.subin.framework.pattern.factory.Bmw;
import com.subin.framework.pattern.factory.Car;
import com.subin.framework.pattern.factory.func.Factory;

/**
 * @author: subiin
 * @date: 2018/2/4 上午11:35
 * @description:
 */
public class BmwFactory implements Factory {
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
