package com.subin.framework.pattern.singleton;

/**
 * @author: subiin
 * @date: 2018/2/4 下午7:53
 * @description:
 */
public class TestMain {

    public static void main(String[] args) {
        TestSingleton ts1 = TestSingleton.getInstance();
        ts1.setName("james");

        TestSingleton ts2 = TestSingleton.getInstance();
        ts2.setName("tom");

        ts1.printInfo();
        ts2.printInfo();

        if (ts1 == ts2) {
            System.out.println("创建的是同一个实例" + ts1.getName());
        } else {
            System.out.println("创建的不是同一个实例" + ts1.getName());
        }
    }
}
