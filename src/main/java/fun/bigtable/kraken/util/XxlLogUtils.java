package fun.bigtable.kraken.util;

import com.xxl.job.core.context.XxlJobHelper;
import com.yomahub.tlog.context.TLogContext;

/**
 * xxl-job 日志打印
 */
public class XxlLogUtils {

    /**
     * 打印日志, 打印traceId到xxl-job日志
     */
    public static void printLog() {
        XxlJobHelper.log("当前任务traceId {}", TLogContext.getTraceId());
    }

}
