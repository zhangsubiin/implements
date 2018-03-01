package com.subin.framework.springmvc.framework.annotation;

import java.lang.annotation.*;

/**
 * @author: subiin
 * @date: 2018/2/25 上午10:21
 * @description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EMService {
    String value() default "";
}
