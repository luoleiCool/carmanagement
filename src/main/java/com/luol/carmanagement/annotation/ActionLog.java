package com.luol.carmanagement.annotation;

import java.lang.annotation.*;

/**
 * AOP 日志记录
 * @author luolei
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ActionLog {

    /**
     * 日志描述
     * @return
     */
    String description() default "";



}
