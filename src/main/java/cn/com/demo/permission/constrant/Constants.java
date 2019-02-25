package cn.com.demo.permission.constrant;

public final class Constants {

    public final static String LOGINSESSION = "userLogin";

    public final static String USERID = "userId";
    public final static String SESSIONID = "sessionId";
    public final static String NEED_LOGIN = "needLogin";
    public final static String FORCE_UPDATE = "forceUpdate";

    public final static String SESSIONORGINAPP = "appOrginSession";
    public final static String SESSIONDNAME = "userSession";
    public final static String SESSIONDORDERCHANNEL = "orderChannelSession";
    public final static String SESSIONDAIRPORT = "airportSession";

    public final static String DECODE = "decode";
    public final static String DECODE_VALUE = "true";


    public final static String LANGUAGE_CN = "cn";
    public final static String LANGUAGE_TW = "tw";

    public final static String TIPS = "tips";
    public final static String ACTION = "action";

    /**
     * 返回的成功与否标记 : 00 - 失败 11 - 成功 ...
     */
    public final static String STATE = "state";

    /**
     * 返回成功
     */
    public final static String STATE_SUCCESS = "11";

    /**
     * 返回失败
     */
    public final static String STATE_FAIL = "00";

    /**
     * 提示内容
     */
    public final static String NOTE = "note";
    public final static String NOTE_BUSY = "系统繁忙，请稍后再试";
    public final static String NOTE_PARAM_ERROR = "参数错误";


    /**
     * 礼宾车接机
     */
    public final static String LIMOUSINE_TYPE_PICKUP = "0";

    /**
     * 礼宾车送机
     */
    public final static String LIMOUSINE_TYPE_DROPOFF = "1";

    /**
     * 会员类型
     */
    public final static String MEMBER_TYPE = "1";


    /**
     * 时间间隔
     * <p>
     * 30分钟
     */
    public final static long FINISH_INTERVAL = 30;

    /**
     * 英文接口默认语言
     */
    public final static String DEFAULT_EN_LANG = "en_US";
    public final static String DEFAULT_SID = "lang";

    public final static String BELONG_CN = "cn";
    public final static String BELONG_EN = "en";
    public final static String PARAM_CN = "zh_CN";
    public final static String PARAM_TW = "zh_TW";


    public final static String VERSION = "version";


    public final static String DATA = "data";

    public final static Integer PAGE_SIZE = 10;
}
