package com.subin.framework.aop.adapter;

import com.subin.framework.aop.advisor.Advisor;
import com.subin.framework.aop.advisor.AfterRunningAdvice;
import com.subin.framework.aop.interceptor.AfterRunningAdviceInterceptor;
import com.subin.framework.aop.interceptor.AopMethodInterceptor;

/**
 * @author: subiin
 * @date: 2018/1/23 下午10:52
 * @description:
 */
public class AfterRunningAdviceAdapter implements AdviceAdapter {

    private static final AfterRunningAdviceAdapter INSTANTS = new AfterRunningAdviceAdapter();

    private AfterRunningAdviceAdapter() {

    }

    public static AfterRunningAdviceAdapter getInstance() {
        return INSTANTS;
    }
    @Override
    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        AfterRunningAdvice advice = (AfterRunningAdvice) advisor.getAdvice();
        return new AfterRunningAdviceInterceptor(advice);
    }
}
