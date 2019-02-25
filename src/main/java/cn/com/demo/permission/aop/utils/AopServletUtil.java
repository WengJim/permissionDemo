package cn.com.demo.permission.aop.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 获取服务请求对象
 *
 * @author ken
 * @version 2015-01-06
 */
public class AopServletUtil {

    private AopServletUtil() {
    }

    private static AopServletUtil aopServletUtil = null;

    public static AopServletUtil getInstance() {

        if (aopServletUtil == null) {
            aopServletUtil = new AopServletUtil();
        }

        return aopServletUtil;
    }

    /**
     * 获取 HttpServletRequest 对象
     */
    public HttpServletRequest getRequest(Object[] args) {

        HttpServletRequest request = null;
        Object o = null;

        if (args == null || args.length == 0) {
            return WebServletUtil.getInstance().getRequest();
        }

        for (int i = 0; i < args.length; i++) {
            o = args[i];

            if (o instanceof HttpServletRequest) {
                request = (HttpServletRequest) o;
                break;
            }
        }
        return request;
    }

    /**
     * 获取 HttpServletResponse 对象
     */
    public HttpServletResponse getResponse(Object[] args) {
        HttpServletResponse response = null;
        Object o = null;

        if (args == null || args.length == 0) {
            return null;
        }

        for (int i = 0; i < args.length; i++) {
            o = args[i];

            if (o instanceof HttpServletResponse) {
                response = (HttpServletResponse) o;
                break;
            }
        }
        return response;
    }

    /**
     * 获取 HttpSession 对象
     */
    public HttpSession getSession(Object[] args) {
        HttpSession session = getRequest(args).getSession();
        return session;
    }

}
