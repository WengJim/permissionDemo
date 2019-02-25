package cn.com.demo.permission.aop.annotition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 可以使用接口是否有权限访问
 * @author jimw
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {
    String message() default "登陆状态已经失效，请重新登陆！";
}
