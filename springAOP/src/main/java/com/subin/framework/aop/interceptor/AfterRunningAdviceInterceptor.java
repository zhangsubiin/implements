package com.subin.framework.aop.interceptor;

import com.subin.framework.aop.advisor.AfterRunningAdvice;
import com.subin.framework.aop.invocation.MethodInvocation;

/**
 * @author: subiin
 * @date: 2018/1/23 下午9:59
 * @description:
 */
public class AfterRunningAdviceInterceptor implements AopMethodInterceptor {

    private AfterRunningAdvice advice;

    public AfterRunningAdviceInterceptor(AfterRunningAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object returnVal = mi.proceed();
        advice.after(returnVal, mi.getMethod(), mi.getArguments(), mi);
        return returnVal;
    }
}
