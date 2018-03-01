package com.subin.framework.designmode.template;

/**
 * @author: subiin
 * @date: 2018/2/4 下午4:07
 * @description:
 */
public class Tea extends Bevegrage {
    @Override
    public void pourInCup() {
        System.out.println("将茶叶放入杯中");
    }

    @Override
    public void addCoundiments() {
        System.out.println("添加蜂蜜");
    }
}
