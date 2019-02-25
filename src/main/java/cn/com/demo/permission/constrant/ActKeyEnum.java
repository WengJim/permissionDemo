package cn.com.demo.permission.constrant;

/**
 * 活动key
 */
public enum ActKeyEnum {
    /***
     * 新年活动
     */
    NEW_YEAR_ACT("NEW:YEAR:ACT", 213),;

    private String value;
    private int key;

    ActKeyEnum(String value, int key) {
        this.key = key;
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }
}
