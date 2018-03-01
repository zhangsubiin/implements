package com.subin.framework.aop.core;

import com.subin.framework.aop.advisor.AdvisedSupport;
import com.subin.framework.ioc.utils.ClassUtils;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author: subiin
 * @date: 2018/1/23 下午10:23
 * @description:
 */
public class CglibAopProxy implements AopProxy {

    private AdvisedSupport advisedSupport;

    private Object[] constructorArgs;

    private Class<?>[] constructorArgTypes;

    public CglibAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    @Override
    public Object getProxy() {
        return getProxy(null);
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        Class<?> targetClass = advisedSupport.getTargetSource().getTargetClass();

        if (classLoader == null) {
            classLoader = ClassUtils.getDefaultClassLoader();
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass.getSuperclass());
        //增加拦截器核心方法
        Callback callbacks = getCallBack(advisedSupport);
        enhancer.setCallback(callbacks);
        enhancer.setClassLoader(classLoader);

        if (constructorArgs != null && constructorArgTypes.length > 0) {
            return enhancer.create(constructorArgTypes, constructorArgs);
        }
        return enhancer.create();
    }

    private Callback getCallBack(AdvisedSupport advisedSupport) {
        return new DynamicAdvisedInterceptor(advisedSupport.getList(), advisedSupport.getTargetSource());
    }
}
