package com.subin.framework.aop.invocation;

import com.subin.framework.aop.interceptor.AopMethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author: subiin
 * @date: 2018/1/23 下午10:11
 * @description: 重写了 invokeOriginal 方法。使用代理类来调用被增强的方法。
 */
public class CglibMethodInvocation extends ReflectioveMethodeInvocation {

    private MethodProxy methodProxy;

    public CglibMethodInvocation(Object proxy, Object target, Method method, Object[] arguments, List<AopMethodInterceptor> interceptorList, MethodProxy methodProxy) {
        super(proxy, target, method, arguments, interceptorList);
        this.methodProxy = methodProxy;
    }

    @Override
    protected Object invokeOriginal() throws Throwable {
        return methodProxy.invoke(target, arguments);
    }
}
