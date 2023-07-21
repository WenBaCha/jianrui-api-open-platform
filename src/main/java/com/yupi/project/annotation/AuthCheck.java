package com.yupi.project.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限校验
 *
   
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {

    /**
     * 有任何一个角色
     *
     * @return
     */
    String[] anyRole() default "";

    // https://t.zsxq.com/0emozsIJh

    /**
     * 必须有某个角色
     *
     * @return
     */
    String mustRole() default "";

}

