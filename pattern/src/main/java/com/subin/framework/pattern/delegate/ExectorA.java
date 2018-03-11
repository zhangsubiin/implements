package com.subin.framework.pattern.delegate;

/**
 * @author: subiin
 * @date: 2018/2/4 下午12:44
 * @description:
 */
public class ExectorA implements IExector {
    @Override
    public void doing() {
        System.out.println("员工A开始执行任务");
    }
}
