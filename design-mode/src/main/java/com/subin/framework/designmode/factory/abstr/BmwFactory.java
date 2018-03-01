package com.subin.framework.designmode.factory.abstr;

import com.subin.framework.designmode.factory.Bmw;
import com.subin.framework.designmode.factory.Car;
import com.subin.framework.designmode.factory.func.Factory;

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
