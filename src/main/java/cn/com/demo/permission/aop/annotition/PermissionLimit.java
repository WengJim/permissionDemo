package cn.com.demo.permission.aop.annotition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jimw
 * 接口访问限制
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionLimit {

    /**
     * 访问控制名称
     *
     * @return
     */
    String[] name() default "";

}
