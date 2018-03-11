package com.subin.framework.pattern.delegate;

/**
 * @author: subiin
 * @date: 2018/2/4 下午12:44
 * @description:
 */
public class ExectorB implements IExector {
    @Override
    public void doing() {
        System.out.println("员工B开始执行任务");
    }
}
