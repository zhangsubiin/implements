package com.subin.framework.aop.invocation;

import java.lang.reflect.Method;

/**
 * @author: subiin
 * @date: 2018/1/23 下午9:42
 * @description: 用于描述方法的调用
 */
public interface MethodInvocation {

    /**
     * 获取方法本身
     * @return
     */
    Method getMethod();

    /**
     * 获取方法参数
     * @return
     */
    Object[] getArguments();

    /**
     * 执行方法本身
     * @return
     * @throws Throwable
     */
    Object proceed() throws Throwable;
}
