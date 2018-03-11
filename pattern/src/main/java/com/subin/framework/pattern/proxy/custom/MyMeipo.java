package com.subin.framework.pattern.proxy.custom;

import com.subin.framework.pattern.proxy.jdk.Person;

import java.lang.reflect.Method;

/**
 * @author: subiin
 * @date: 2018/2/3 下午2:20
 * @description:
 */
public class MyMeipo implements MyInvocationHandler {

    private Person target;

    public Object getInstance(Person target) throws Exception {
        this.target = target;
        Class clazz = target.getClass();
        System.out.println("被代理对象是：" + clazz);
        return MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆");
        System.out.println("开始进行海选...");
        System.out.println("------------");

        //调用的时候
        method.invoke(this.target, args);

        System.out.println("------------");
        System.out.println("如果合适的话，就准备办事");
        return null;
    }
}
