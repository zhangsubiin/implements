package com.subin.framework.designmode.factory.abstr;

import com.subin.framework.designmode.factory.Car;

/**
 * @author: subiin
 * @date: 2018/2/4 上午11:46
 * @description:
 */
public class DefaultFactory extends AbstractFactory {

    private AudiFactory defaultFactory = new AudiFactory();

    @Override
    protected Car getCar() {
        return defaultFactory.getCar();
    }
}
