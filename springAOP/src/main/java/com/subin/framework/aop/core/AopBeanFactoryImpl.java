package com.subin.framework.aop.core;

import com.subin.framework.aop.adapter.AfterRunningAdviceAdapter;
import com.subin.framework.aop.adapter.BeforeMethodAdviceAdapter;
import com.subin.framework.aop.advisor.*;
import com.subin.framework.aop.bean.AopBeanDefinition;
import com.subin.framework.aop.interceptor.AopMethodInterceptor;
import com.subin.framework.ioc.core.BeanFactoryImpl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: subiin
 * @date: 2018/1/23 下午10:39
 * @description: 产生代理对象的工厂类，继承了上一讲我们实现的 IoC 容器的 BeanFactoryImpl。
 * 重写了 getBean 方法，如果是一个切面代理类，我们使用 Aop 框架生成代理类，
 * 如果是普通的对象，我们就用原来的 IoC 容器进行依赖注入。
 * getAdvisedSupport就是获取 Aop 框架认识的数据结构。
 */
public class AopBeanFactoryImpl extends BeanFactoryImpl {

    private static final ConcurrentHashMap<String, AopBeanDefinition> aopBeanDefinitionMap = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String, Object> aopBeanMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) throws Exception {

        Object aopBean = aopBeanMap.get(name);

        if (aopBean != null) {
            return aopBean;
        }

        if (aopBeanDefinitionMap.containsKey(name)) {
            AopBeanDefinition aopBeanDefinition = aopBeanDefinitionMap.get(name);
            AdvisedSupport advisedSupport = getAdvisedSupport(aopBeanDefinition);
            aopBean = new CglibAopProxy(advisedSupport).getProxy();
            aopBeanMap.put(name, aopBean);
            return aopBean;
        }

        return super.getBean(name);
    }

    protected void registerBean(String name, AopBeanDefinition aopBeanDefinition) {
        aopBeanDefinitionMap.put(name, aopBeanDefinition);
    }

    private AdvisedSupport getAdvisedSupport(AopBeanDefinition aopBeanDefinition) throws Exception {

        AdvisedSupport advisedSupport = new AdvisedSupport();
        List<String> interceptorNames = aopBeanDefinition.getInterceptorNames();
        if (interceptorNames != null && !interceptorNames.isEmpty()) {
            for (String interceptorName : interceptorNames) {

                Advice advice = (Advice) getBean(interceptorName);

                Advisor advisor = new Advisor();
                advisor.setAdvice(advice);

                if (advice instanceof BeforeMethodAdvice) {
                    AopMethodInterceptor interceptor = BeforeMethodAdviceAdapter.getInstance().getInterceptor(advisor);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }

                if (advice instanceof AfterRunningAdvice) {
                    AopMethodInterceptor interceptor = AfterRunningAdviceAdapter.getInstance().getInterceptor(advisor);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }
            }
        }

        TargetSource targetSource = new TargetSource();

        Object object = getBean(aopBeanDefinition.getTarget());

        targetSource.setTargetClass(object.getClass());
        targetSource.setTargetObject(object);

        advisedSupport.setTargetSource(targetSource);

        return advisedSupport;
    }
}
