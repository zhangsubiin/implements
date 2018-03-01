package com.subin.framework.designmode.factory.abstr;

import com.subin.framework.designmode.factory.Benz;
import com.subin.framework.designmode.factory.Car;
import com.subin.framework.designmode.factory.func.Factory;

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
