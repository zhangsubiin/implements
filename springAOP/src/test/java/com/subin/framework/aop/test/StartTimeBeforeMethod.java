package com.subin.framework.aop.test;

import com.subin.framework.aop.advisor.BeforeMethodAdvice;

import java.lang.reflect.Method;

/**
 * @author: subiin
 * @date: 2018/1/24 下午11:40
 * @description:
 */
public class StartTimeBeforeMethod implements BeforeMethodAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) {
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间");
        ThreadLocalUtils.set(startTime);
    }
}
