package com.subin.framework.designmode.delegate;

/**
 * @author: subiin
 * @date: 2018/2/4 下午12:45
 * @description:
 */
public class Dispatcher implements IExector {

    private IExector exector;

    Dispatcher(IExector exector) {
        this.exector = exector;
    }

    /**
     * 项目经理，虽然也有执行方法，但是职责不一样
     */
    @Override
    public void doing() {
        this.exector.doing();
    }
}
