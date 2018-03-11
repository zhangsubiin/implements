package com.subin.framework.pattern.factory.abstr;

import com.subin.framework.pattern.factory.Audi;
import com.subin.framework.pattern.factory.Car;

/**
 * @author: subiin
 * @date: 2018/2/4 上午11:43
 * @description:
 */
public class AudiFactory extends AbstractFactory {
    @Override
    protected Car getCar() {
        return new Audi();
    }
}
