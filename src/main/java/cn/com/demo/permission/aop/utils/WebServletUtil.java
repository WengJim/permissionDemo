package cn.com.demo.permission.aop.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 获取服务请求对象
 *
 * @author ken
 * @version 2015-01-06
 */
public class WebServletUtil {

    private WebServletUtil() {
    }

    private static WebServletUtil webServletUtil = null;

    public static WebServletUtil getInstance() {

        if (webServletUtil == null) {
            webServletUtil = new WebServletUtil();
        }

        return webServletUtil;
    }

    /**
     * 获取 HttpServletRequest 对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 获取 HttpSession 对象
     */
    public HttpSession getSession() {
        HttpSession session = getRequest().getSession();
        return session;
    }

	/*
	public void goUrl(String Url) {
		try {
			HttpServletResponse response = getResponse();
			response.sendRedirect(Url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void goUrl(String Url,String alert) {
		String msg = "<script>alert('" + alert + "');window.location='"+Url+"';</script>";
		try {
			HttpServletResponse response = getResponse();
			response.getWriter().print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void goHistory(String title) {
		String msg = "<script>alert('" + title + "');history.go(-1);</script>";
		try {
			HttpServletResponse response = getResponse();
			response.getWriter().print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void closeWindow(String title){
		String msg = "<script>alert('" + title + "');window.close();</script>";
		try {
			HttpServletResponse response = getResponse();
			response.getWriter().print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/

}
