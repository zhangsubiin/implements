package com.subin.framework.aop.bean;

import com.subin.framework.ioc.bean.BeanDefinition;
import lombok.Data;

import java.util.List;

/**
 * @author: subiin
 * @date: 2018/1/23 下午10:40
 * @description:
 */
@Data
public class AopBeanDefinition extends BeanDefinition {

    private String target;

    private List<String> interceptorNames;
}
