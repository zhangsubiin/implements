package com.subin.framework.designmode.factory.func;

import com.subin.framework.designmode.factory.Audi;
import com.subin.framework.designmode.factory.Car;

/**
 * @author: subiin
 * @date: 2018/2/4 上午11:35
 * @description:
 */
public class AudiFactory implements Factory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
