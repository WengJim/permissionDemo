package cn.com.demo.permission.core.api;

import lombok.Data;

/**
 * @author jimw
 * 参数封装。跟resultData返回数据一致
 * @param <T>
 */
@Data
public class ApiResult<T> {

    private String state;
    private String note;
    private String errorCode;
    private T data;

    public ApiResult() {
    }

    public ApiResult(String code, String note, T data) {
        super();
        this.state = code;
        this.note = note;
        this.data = data;
    }

    public ApiResult(String code, String note) {
        super();
        this.state = code;
        this.note = note;
    }

    public ApiResult(String code, String note, String errorCode) {
        super();
        this.state = code;
        this.note = note;
        this.errorCode = errorCode;
    }


    /**
     * 返回成功信息
     */
    public static ApiResult success() {
        return generate(ApiResultCodeMsg.SUCCESS.getCode(),
                ApiResultCodeMsg.SUCCESS.getMsg());
    }

    /**
     * 返回成功信息
     */
    public static ApiResult success(Object data) {
        return generate(ApiResultCodeMsg.SUCCESS.getCode(),
                ApiResultCodeMsg.SUCCESS.getMsg(), data);
    }
    /**
     * 返回错误信息
     *
     * @param
     * @return
     */
    public static ApiResult error() {
        return generate(ApiResultCodeMsg.FAIL.getCode(),
                ApiResultCodeMsg.FAIL.getCode());
    }


    /**
     * 返回错误信息
     *
     * @param note
     * @return
     */
    public static ApiResult error(String note,Object data) {
        return generate(ApiResultCodeMsg.FAIL.getCode(),
                note, data);
    }


    /**
     * 返回错误信息
     *
     * @param note
     * @return
     */
    public static ApiResult error(String note) {
        return generate(ApiResultCodeMsg.FAIL.getCode(),
                note, null);
    }

    /**
     * 返回错误信息
     *
     * @param note,errorCode
     * @return
     */
    public static ApiResult error(String note, String errorCode) {
        return generate(errorCode,
                note);
    }


    /**
     * 构造Result对象
     */
    public static ApiResult generate(String code, String msg) {
        return generate(code, msg, null);
    }


    /**
     * 构造Result对象
     */
    public static ApiResult generate(String code, String msg, String errorCode) {
        return new ApiResult(code, msg, errorCode);
    }

    /**
     * 构造Result对象
     */
    public static ApiResult generate(String code, String msg, Object data) {
        return new ApiResult(code, msg, data);
    }
}
