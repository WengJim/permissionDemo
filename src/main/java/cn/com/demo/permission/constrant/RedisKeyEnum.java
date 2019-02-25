package cn.com.demo.permission.constrant;

public enum RedisKeyEnum {
    /***
     * 用户的token操作
     */
    TOTAL_CARDS("TOTAL:CARDS:{0}", 60*60*24*30*2),
    /**
     * 保证token只能获取一次有效
     */
    USER_TOKEN("USER:TOKEN:{0}", 60*60*5),
    ;

    private String key;
    private int time;

    RedisKeyEnum(String key, int time) {
        this.key = key;
        this.time = time;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
