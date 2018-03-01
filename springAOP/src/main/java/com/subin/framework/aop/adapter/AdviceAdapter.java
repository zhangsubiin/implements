package com.subin.framework.aop.adapter;

import com.subin.framework.aop.advisor.Advisor;
import com.subin.framework.aop.interceptor.AopMethodInterceptor;

/**
 * @author: subiin
 * @date: 2018/1/23 下午10:51
 * @description:
 */
public interface AdviceAdapter {

    AopMethodInterceptor getInterceptor(Advisor advisor);
}
