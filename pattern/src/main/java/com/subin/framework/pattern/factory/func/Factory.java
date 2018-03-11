package com.subin.framework.pattern.factory.func;

import com.subin.framework.pattern.factory.Car;

/**
 * @author: subiin
 * @date: 2018/2/4 上午11:33
 * @description: 工厂接口，定义了所有工厂的执行标准
 */
public interface Factory {

    /**
     * 符合汽车上路标准
     * 尾气排放标准
     * 电子设备安全系数
     * @return
     */
    Car getCar();
}
