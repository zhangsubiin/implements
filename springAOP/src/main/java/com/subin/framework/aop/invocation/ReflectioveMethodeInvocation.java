package com.subin.framework.aop.invocation;

import com.subin.framework.aop.interceptor.AopMethodInterceptor;
import com.subin.framework.aop.utils.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author: subiin
 * @date: 2018/1/23 下午10:01
 * @description:
 */
public class ReflectioveMethodeInvocation implements ProxyMethodInvocation {

    protected final Object proxy;

    protected final Object target;

    protected final Method method;

    protected Object[] arguments;

    protected final List<AopMethodInterceptor> interceptorList;

    private int currentInterceptorIndex = -1;

    public ReflectioveMethodeInvocation(Object proxy, Object target, Method method, Object[] arguments, List<AopMethodInterceptor> interceptorList) {
        this.proxy = proxy;
        this.target = target;
        this.method = method;
        this.arguments = arguments;
        this.interceptorList = interceptorList;
    }

    @Override
    public Object getProxy() {
        return null;
    }

    @Override
    public Method getMethod() {
        return null;
    }

    @Override
    public Object[] getArguments() {
        return new Object[0];
    }

    @Override
    public Object proceed() throws Throwable {

        //执行完所有的拦截器后，执行目标方法
        if (currentInterceptorIndex == this.interceptorList.size() - 1) {
            return invokeOriginal();
        }

        //迭代的执行拦截器
        AopMethodInterceptor aopMethodInterceptor = interceptorList.get(++currentInterceptorIndex);
        return aopMethodInterceptor.invoke(this);
    }

    protected Object invokeOriginal() throws Throwable {
        return ReflectionUtils.invokeMethodUseReflection(target, method, arguments);
    }
}
