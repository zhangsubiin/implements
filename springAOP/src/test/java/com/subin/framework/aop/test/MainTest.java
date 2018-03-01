package com.subin.framework.aop.test;

import com.subin.framework.aop.core.AopApplictionContext;

/**
 * @author: subiin
 * @date: 2018/1/24 下午11:49
 * @description:
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
        AopApplictionContext aopApplictionContext = new AopApplictionContext("application.json");
        aopApplictionContext.init();

        TestService testService = (TestService) aopApplictionContext.getBean("testServiceProxy");

        testService.testMethod();
    }
}
