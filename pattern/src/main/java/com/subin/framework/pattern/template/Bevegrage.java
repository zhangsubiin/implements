package com.subin.framework.pattern.template;

/**
 * @author: subiin
 * @date: 2018/2/4 下午4:04
 * @description:
 */
public abstract class Bevegrage {

    //不能被重写
    public final void create() {
        //1、把水烧开
        boilWater();
        //2、把被子准备好，原材料放到杯中
        pourInCup();
        //3、用水冲泡
        brew();
        //4、添加辅料
        addCoundiments();
    }

    public abstract void pourInCup();

    public abstract void addCoundiments();

    public void boilWater() {
        System.out.println("烧开水");
    }

    public void brew() {
        System.out.println("将开水倒入杯中进行冲泡");
    }
}
