package com.subin.framework.pattern.template;

/**
 * @author: subiin
 * @date: 2018/2/4 下午4:07
 * @description:
 */
public class Coffee extends Bevegrage {
    @Override
    public void pourInCup() {
        System.out.println("将咖啡倒入杯中");
    }

    @Override
    public void addCoundiments() {
        System.out.println("添加牛奶和糖");
    }
}
