package com.subin.framework.designmode.singleton;

/**
 * @author: subiin
 * @date: 2018/2/4 下午6:54
 * @description:
 */
public class Singleton2 {
    private static Singleton2 single = null;

    private Singleton2() {

    }

    public static synchronized Singleton2 getInstance() {
        if (single == null) {
            single = new Singleton2();
        }

        return single;
    }
}
