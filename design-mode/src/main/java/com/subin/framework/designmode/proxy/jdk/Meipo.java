package com.subin.framework.designmode.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: subiin
 * @date: 2018/2/3 下午1:51
 * @description:
 */
public class Meipo implements InvocationHandler {

    /**
     * 被代理对象的引用作为一个成员变量保存了下来
     */
    private Person target;

    public Object getInstance(Person target) throws Exception {
        this.target = target;
        Class clazz = target.getClass();
        System.out.println("被代理对象是：" + clazz);
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆：得给你找个异性才行");
        System.out.println("开始进行海选...");
        System.out.println("------------");

        //调用的时候
//        this.target.findLove();
        method.invoke(this.target, args);

        System.out.println("------------");
        System.out.println("如果合适的话，就准备办事");
        return null;
    }
}
