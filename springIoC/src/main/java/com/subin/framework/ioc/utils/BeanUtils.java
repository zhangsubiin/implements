package com.subin.framework.ioc.utils;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @author: subiin
 * @date: 2018/1/14 上午10:55
 * @description: 负责处理对象的实例化
 */
public class BeanUtils {

    public static <T> T instanceByCglib(Class<T> clz, Constructor ctr, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clz);
        enhancer.setCallback(NoOp.INSTANCE);
        if (ctr == null) {
            return (T) enhancer.create();
        } else {
            return (T) enhancer.create(ctr.getParameterTypes(), args);
        }
    }
}
