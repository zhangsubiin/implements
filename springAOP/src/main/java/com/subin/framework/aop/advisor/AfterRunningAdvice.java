package com.subin.framework.aop.advisor;

import java.lang.reflect.Method;

/**
 * @author: subiin
 * @date: 2018/1/23 下午9:55
 * @description:
 */
public interface AfterRunningAdvice extends Advice {
    /**
     * 方法执行之后进行拦截
     * @param returnVal
     * @param method
     * @param args
     * @param target
     * @return
     */
    Object after(Object returnVal, Method method, Object[] args, Object target);
}
