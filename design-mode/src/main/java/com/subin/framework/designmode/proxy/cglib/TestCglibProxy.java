package com.subin.framework.designmode.proxy.cglib;

/**
 * @author: subiin
 * @date: 2018/2/3 下午5:18
 * @description:
 */
public class TestCglibProxy {
    public static void main(String[] args) {

        //JDK的动态代理是通过接口来进行强制转换的
        //生成以后的代理对象，可以强制转换为接口

        //CGLib的动态代理是通过生成一个被代理对象的子类，然后重写父类的方法
        //生成以后的对象，可以强制装换为被代理对象（也就是用自己写的类）
        //子类引用赋值给父类

        try {
            Lisi lisi = (Lisi) new CGLibMeipo().getInstance(Lisi.class);
            lisi.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
