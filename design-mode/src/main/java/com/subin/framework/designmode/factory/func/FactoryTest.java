package com.subin.framework.designmode.factory.func;

/**
 * @author: subiin
 * @date: 2018/2/4 上午11:36
 * @description:
 */
public class FactoryTest {
    public static void main(String[] args) {

        //工厂方法模式
        Factory factory = new AudiFactory();
        System.out.println(factory.getCar());

        //需要用户关心，这个产品的生产商
        //增加代码的使用复杂度
        factory = new BmwFactory();
        System.out.println(factory.getCar());
    }
}
