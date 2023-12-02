package fun.bigtable.kraken.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 基于JAVA8的DateTime工具，使用了JAVA8的新增工具
 *
 */
public class DateTimeUtils {

    /**
     * 默认的时间字符串格式
     */
    public static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 默认的日期字符串格式
     */
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 默认的月份字符串格式
     */
    public static final String DEFAULT_MONTH_PATTERN = "yyyy-MM";

    /**
     * 根据指定的字符串格式输出当前时间
     *
     * @param pattern 时间字符串格式
     */
    public static String currentDateTimeString(String pattern) {

        // 创建JAVA8时间包的formatter
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);

        // 获取当前时间
        LocalDateTime time = LocalDateTime.now();

        return df.format(time);

    }

    /**
     * 使用默认的时间格式获取当前时间的字符串
     */
    public static String currentDateTimeString() {
        return currentDateTimeString(DEFAULT_DATE_TIME_PATTERN);
    }

    /**
     * 按照默认格式输出时间字符串
     *
     * @param date 日期
     * @return 日期字符串
     */
    public static String formateDate(LocalDate date) {
        // 创建JAVA8时间包的formatter
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);
        return df.format(date);
    }

    /**
     * 按照默认格式输出时间字符串
     *
     * @param dateTime 时间
     * @return 日期字符串
     */
    public static String formateDate(LocalDateTime dateTime) {
        // 创建JAVA8时间包的formatter
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_PATTERN);
        return df.format(dateTime);
    }

    public static String formatMonth(LocalDateTime localDateTime) {
        // 创建JAVA8时间包的formatter
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DEFAULT_MONTH_PATTERN);
        return df.format(localDateTime);
    }

    /**
     * 计算指定时间距当前的时间差
     *
     * @param beginTime 起始时间
     * @param timeUnit  要转换的时间单位
     * @return 相差的时间
     */
    public static int getTimeDiffToNow(String beginTime, TimeUnit timeUnit) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = LocalDateTime.parse(beginTime, DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_PATTERN));
        long timeDiff;

        switch (timeUnit) {
            case SECONDS:
                timeDiff = Duration.between(start, now).toMillis() / 1000;
                break;
            case MINUTES:
                timeDiff = Duration.between(start, now).toMinutes();
                break;
            case HOURS:
                timeDiff = Duration.between(start, now).toHours();
                break;
            default:
                timeDiff = 0;
                break;
        }

        return Integer.parseInt(String.valueOf(timeDiff));
    }

    /**
     * 将时间戳时间转换为北京时间
     *
     * @param timestamp 时间戳
     * @return 北京时间
     */
    public static String getFormatLocalTime(Long timestamp) {
        return DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_PATTERN).format(
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneOffset.systemDefault())
        );
    }

    public static LocalDateTime parserDateTime(String dateTime) {
        return parserDateTime(dateTime, DEFAULT_DATE_TIME_PATTERN);
    }

    public static LocalDateTime parserDateTime(String dateTime, String pattern) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(pattern));
    }

    public static Date fromDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
    }

    public static LocalDateTime formDateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.systemDefault());
    }
}