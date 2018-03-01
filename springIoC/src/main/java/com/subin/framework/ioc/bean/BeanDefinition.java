package com.subin.framework.ioc.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author: subiin
 * @date: 2018/1/14 上午10:51
 * @description:
 */
@Data
@ToString
public class BeanDefinition {

    private String name;

    private String className;

    private String interfaceName;

    private List<ConstructorArg> constructorArgs;

    private List<PropertyArg> propertyArgs;
}
