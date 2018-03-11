package com.subin.framework.pattern.delegate;

/**
 * @author: subiin
 * @date: 2018/2/4 下午12:47
 * @description:
 */
public class DispatcherTest {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(new ExectorA());

        //看上去好像是我们的项目经理在干活
        //但实际干活的人是普通员工
        dispatcher.doing();
    }
}
