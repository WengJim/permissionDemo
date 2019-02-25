package cn.com.demo.permission.utils;

import cn.com.demo.permission.dto.SysUserInfo;
import cn.com.demo.permission.dto.SysUserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/6/15.
 */
public class TokenUtils {

    private static Logger logger = LoggerFactory.getLogger(TokenUtils.class);

    private static ThreadLocal<SysUserInfo> local = new ThreadLocal<>();


    public static void setToken(String token) {
        if (StringUtils.isBlank(token)) {
            return;
        }
        //根据token获取用户信息以及资源
        //logger.info("currentThread:{},restResponse:{} ", Thread.currentThread().getId(), JSON.toJSONString(restResponse));
        // if (restResponse.getData() != null) {
        //     local.set(restResponse.getData());
        // }
    }

    public static SysUserInfo getUserInfo() {
        return new ObjectMapper().convertValue(local.get(), SysUserInfo.class);
    }


    public static void refreshThread() {
        local.remove();
    }
}
