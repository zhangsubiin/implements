package com.subin.framework.ioc.utils;

/**
 * @author: subiin
 * @date: 2018/1/14 上午10:53
 * @description: 负责处理 Java 类的加载
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class loadClass(String className) {
        try {
            return getDefaultClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
