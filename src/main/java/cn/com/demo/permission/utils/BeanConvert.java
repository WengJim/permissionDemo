package cn.com.demo.permission.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;

/**
 * 数据强制类型
 */
public class BeanConvert {
    public BeanConvert() {
    }

    /**
     * Object 转list
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static final <T> T toJavaObjectList(Object json, Class<T> clazz) {
        return TypeUtils.cast(JSONArray.parseArray(JSONArray.toJSONString(json)), clazz, ParserConfig.getGlobalInstance());
    }

    /**
     * Object 转实体
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static final <T> T toJavaObject(Object json, Class<T> clazz) {
        return TypeUtils.cast(JSONObject.parseObject(JSONObject.toJSONString(json)), clazz, ParserConfig.getGlobalInstance());
    }


}
