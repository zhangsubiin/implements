package com.subin.framework.aop.advisor;

import java.lang.reflect.Method;

/**
 * @author: subiin
 * @date: 2018/1/23 下午9:51
 * @description:
 */
public interface BeforeMethodAdvice extends Advice {
    /**
     * 方法执行以前进行拦截
     * @param method
     * @param args
     * @param target
     */
    void before(Method method, Object[] args, Object target);
}
