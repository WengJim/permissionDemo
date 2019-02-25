package cn.com.demo.permission.core.api;

/**
 * @author jimw
 * @date 2019-1-21
 * @Description Controller层返回的统一结果对象信息码
 */
public enum ApiResultCodeMsg {
    /**
     * 成功
     */
    SUCCESS("11", "成功"),

    /**
     * 失败
     */
    FAIL("00", "系统异常");


    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ApiResultCodeMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据状态码获取到对应的提示信息
     *
     * @param code
     * @return
     */
    public static String getMsg(String code) {
        for (ApiResultCodeMsg resultCodeMsg : values()) {
            if (resultCodeMsg.getCode().equals(code)) {
                return resultCodeMsg.getMsg();
            }
        }
        return null;
    }

}
