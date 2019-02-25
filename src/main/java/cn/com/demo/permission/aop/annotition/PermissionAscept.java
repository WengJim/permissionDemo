package cn.com.demo.permission.aop.annotition;

import cn.com.demo.permission.aop.utils.AopServletUtil;
import cn.com.demo.permission.dto.SysUserInfo;
import cn.com.demo.permission.utils.TokenUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * 接口访问限制权限
 *
 * @author jimw
 * @date 2019-2-25
 */
@Aspect
@Component
public class PermissionAscept implements Ordered {
    private Logger logger = LoggerFactory.getLogger(PermissionAscept.class.getName());


    @Pointcut("execution(*   cn.com.demo.act.activity.controller..*.*(..)) && @annotation( cn.com.demo.act.activity.aop.annotition.PermissionLimit) ")
    private void Intercepter() {
    }

    /**
     * 切面限制
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("Intercepter()")
    public Object doAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object[] args = joinPoint.getArgs();
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            PermissionLimit annotation = method.getAnnotation(PermissionLimit.class);
            HttpServletRequest request = AopServletUtil.getInstance().getRequest(args);
            Object proceed;
            if (request == null) {
                proceed = joinPoint.proceed();
            } else {
                boolean check = checkTotal(annotation);
                Assert.isTrue(check, "无权限访问");
                proceed = joinPoint.proceed();
            }
            return proceed;
        } catch (IllegalArgumentException e) {
            logger.error("doAspect:{}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("doAspect:{}", e.getMessage(), e);
            Assert.notNull(null, "系统繁忙");
        }
        return null;
    }

    /**
     * 总限制
     *
     * @param annotation
     * @return
     */
    private boolean checkTotal(PermissionLimit annotation) {
        SysUserInfo userInfo = TokenUtils.getUserInfo();

        if (userInfo.getUserId() == 1L) {
            return true;
        }
        String[] annotationName = annotation.name();
        List<String> stringB = Arrays.asList(annotationName);
        for (String string : stringB) {
            if (userInfo.getResources().contains(string)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }

}