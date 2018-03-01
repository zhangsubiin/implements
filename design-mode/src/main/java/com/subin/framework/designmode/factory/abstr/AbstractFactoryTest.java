package com.subin.framework.designmode.factory.abstr;

/**
 * @author: subiin
 * @date: 2018/2/4 上午11:46
 * @description:
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        DefaultFactory factory = new DefaultFactory();

        System.out.println(factory.getCar("benz"));
    }
}
