package fun.bigtable.kraken.util;

import org.apache.logging.log4j.message.FormattedMessage;

public class MyFormatUtils {

    public static String format(String text, Object... args) {
        return new FormattedMessage(text, args).getFormattedMessage();
    }
}
