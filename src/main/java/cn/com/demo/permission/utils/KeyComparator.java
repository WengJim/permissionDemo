package cn.com.demo.permission.utils;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jimw
 * @date 2019-1-17
 * description 排序比较类
 */
public class KeyComparator {


    /**
     * 使用 Map按key进行排序
     *
     * @param map
     * @return
     */
    public static Map<String, Object> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, Object> sortMap = new TreeMap<String, Object>(
                new MapKeyComparator());
        sortMap.putAll(map);
        //去掉签名
        sortMap.remove("sign");
        return sortMap;
    }
}
class MapKeyComparator implements Comparator<String>

{
    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
}

