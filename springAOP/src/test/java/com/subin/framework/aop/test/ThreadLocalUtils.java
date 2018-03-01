package com.subin.framework.aop.test;

/**
 * @author: subiin
 * @date: 2018/1/24 下午11:41
 * @description:
 */
public class ThreadLocalUtils {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static long get() {
        if (threadLocal == null) {
            throw new IllegalStateException("ThreadLocal");
        }
        return threadLocal.get();
    }

    public static void set(long startTime) {
        threadLocal.set(startTime);
    }

    public static void remove() {
        threadLocal.remove();
    }
}
