package com.subin.framework.pattern.proxy.custom;

import java.lang.reflect.Method;

/**
 * @author: subiin
 * @date: 2018/2/3 下午2:17
 * @description:
 */
public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
