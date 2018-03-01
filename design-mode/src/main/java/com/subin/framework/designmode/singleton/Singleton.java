package com.subin.framework.designmode.singleton;

import java.io.Serializable;

/**
 * @author: subiin
 * @date: 2018/2/4 下午6:47
 * @description:
 */
public class Singleton implements Serializable{

    public static Singleton INSTANCE = new Singleton();

    protected Singleton() {

    }

    private Object readResolve() {
        return INSTANCE;
    }
}
