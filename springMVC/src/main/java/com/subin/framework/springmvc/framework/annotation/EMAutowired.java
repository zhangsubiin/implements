package com.subin.framework.springmvc.framework.annotation;

import java.lang.annotation.*;

/**
 * @author: subiin
 * @date: 2018/2/25 上午10:20
 * @description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EMAutowired {
    String value() default "";
}
