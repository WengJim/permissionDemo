package cn.com.demo.permission.aop.utils;

/**
 * Created by Administrator on 2017/7/28.
 */
public class FollowUtils {
    private static final ThreadLocal<String> LOCAL_HEAD = new ThreadLocal<String>();



    /**
     * @return
     */
    public static String getLocaHead() {
        return LOCAL_HEAD.get();
    }

    public static void setLocaHead(String fid) {
        LOCAL_HEAD.set(fid);
    }

    /**
     * 移除本地变量
     */
    public static void clearLocaHead() {
        LOCAL_HEAD.remove();
    }




}
