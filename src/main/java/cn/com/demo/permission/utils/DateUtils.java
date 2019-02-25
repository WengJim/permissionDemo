package cn.com.demo.permission.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {

    /**
     * 根据时间转换成线程安全的日期类
     *
     * @param date
     * @return
     */
    public static LocalDateTime getLocalDateTime(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime;
    }

    /**
     * 根据线程安全的日期转换位时间
     *
     * @param localDate
     * @return
     */
    public static Date getLocalDateTime(LocalDateTime localDate) {
        Date date = Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }
}
