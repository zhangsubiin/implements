package com.subin.framework.aop.advisor;

import com.subin.framework.aop.interceptor.AopMethodInterceptor;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: subiin
 * @date: 2018/1/23 下午10:17
 * @description:
 */
@Data
public class AdvisedSupport extends Advisor {

    //目标对象
    private TargetSource targetSource;

    //拦截器列表
    private List<AopMethodInterceptor> list = new LinkedList<>();

    public void addAopMethodInterceptor(AopMethodInterceptor interceptor) {
        list.add(interceptor);
    }

    public void addAopMethodInterceptors(List<AopMethodInterceptor> interceptors) {
        list.addAll(interceptors);
    }
}
