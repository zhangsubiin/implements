package com.subin.framework.springmvc.framework.annotation;

import java.lang.annotation.*;

/**
 * @author: subiin
 * @date: 2018/2/25 上午10:20
 * @description:
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EMRequestMapping {
    String value() default "";
}
