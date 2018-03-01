package com.subin.framework.aop.interceptor;

import com.subin.framework.aop.invocation.MethodInvocation;

/**
 * @author: subiin
 * @date: 2018/1/23 下午9:49
 * @description:
 */
public interface AopMethodInterceptor {

    Object invoke(MethodInvocation mi) throws Throwable;
}
