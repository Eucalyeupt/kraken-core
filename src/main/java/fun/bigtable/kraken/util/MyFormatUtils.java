package fun.bigtable.kraken.util;

import org.apache.logging.log4j.message.FormattedMessage;

/**
 * 字符串格式化工具，使用的log4j的格式化，和输出日志一样的写法
 */
public class MyFormatUtils {

    public static String format(String text, Object... args) {
        return new FormattedMessage(text, args).getFormattedMessage();
    }
}
