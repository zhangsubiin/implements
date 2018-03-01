package com.subin.framework.designmode.factory.abstr;

import com.subin.framework.designmode.factory.Audi;
import com.subin.framework.designmode.factory.Car;

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
