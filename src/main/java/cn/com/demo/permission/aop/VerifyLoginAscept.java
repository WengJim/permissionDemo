package cn.com.demo.permission.aop;

import cn.com.demo.permission.aop.utils.AopServletUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jimw
 * demo: 直接在controller上注入
 * @Login 则可以实现拦截
 */
@Aspect
@Component
public class VerifyLoginAscept implements Ordered {

    @Pointcut("@annotation(cn.com.demo.act.activity.aop.annotition.Login)")
    private void loginIntercepter() {
    }

    @Around("loginIntercepter()")
    public Object LoginAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        return loginProcess(joinPoint);
    }

    /**
     * 登录处理
     *
     * @throws Throwable
     */
    private Object loginProcess(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        // 获取Request对象
        HttpServletRequest request = AopServletUtil.getInstance().getRequest(args);

        return null;
    }


    /**
     * 最优先级
     *
     * @return
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
