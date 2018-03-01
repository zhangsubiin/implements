package com.subin.framework.aop.adapter;

import com.subin.framework.aop.advisor.Advisor;
import com.subin.framework.aop.advisor.BeforeMethodAdvice;
import com.subin.framework.aop.interceptor.AopMethodInterceptor;
import com.subin.framework.aop.interceptor.BeforeMethodAdviceInterceptor;

/**
 * @author: subiin
 * @date: 2018/1/23 下午10:59
 * @description:
 */
public class BeforeMethodAdviceAdapter implements AdviceAdapter {
    private static final BeforeMethodAdviceAdapter INSTANTS = new BeforeMethodAdviceAdapter();

    private BeforeMethodAdviceAdapter() {

    }

    public static BeforeMethodAdviceAdapter getInstance() {
        return INSTANTS;
    }
    @Override
    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        BeforeMethodAdvice advice = (BeforeMethodAdvice) advisor.getAdvice();
        return new BeforeMethodAdviceInterceptor(advice);
    }
}
