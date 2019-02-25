package cn.com.demo.permission.configuration;

import cn.com.demo.permission.core.api.ApiResult;
import cn.com.demo.permission.core.api.ApiResultCodeMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;


/**
 * @author jim
 * 全局捕捉异常
 * <p>
 * 在controller function 中使用
 * Assert 工具类，从而减少实现if的判断过滤.最终达到全局捕捉异常输出
 * Assert.isTrue(false,"msg");
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ApiResult defaultErrorHandler(Exception e) {
        log.error("defaultErrorHandler error:{}", e.getMessage());
        if("感谢关注！您已参与过本次秒杀活动敬请期待下次活动".equals(e.getMessage())){
            return ApiResult.error(e.getMessage(),"02");
        }
        if("该机场休息室优惠名额已售完，请选择其他机场吧！".equals(e.getMessage())){
            return ApiResult.error(e.getMessage(),"03");
        }
        return ApiResult.generate(ApiResultCodeMsg.FAIL.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = SQLException.class)
    public ApiResult SQLExceptionHandler(Exception e) {
        log.error("SQLExceptionHandler error:{}", e.getMessage(), e);
        return ApiResult.generate(ApiResultCodeMsg.FAIL.getCode(), "系统繁忙，请稍后再试");
    }


}
