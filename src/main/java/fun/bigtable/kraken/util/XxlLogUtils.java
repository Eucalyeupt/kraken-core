package fun.bigtable.kraken.util;

import com.xxl.job.core.context.XxlJobHelper;
import com.yomahub.tlog.context.TLogContext;

public class XxlLogUtils {

    public static void printLog(){
        XxlJobHelper.log("当前任务traceId {}", TLogContext.getTraceId());
    }

}
