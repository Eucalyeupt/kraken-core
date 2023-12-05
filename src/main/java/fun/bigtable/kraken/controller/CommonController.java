package fun.bigtable.kraken.controller;

import fun.bigtable.kraken.bean.Result;
import fun.bigtable.kraken.dict.DictCache;
import fun.bigtable.kraken.dict.DictInitializer;
import fun.bigtable.kraken.util.DateTimeUtils;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/common")
@RestController
public class CommonController {

    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Resource
    DictInitializer dictInitializer;

    /**
     * 当前时间
     */
    @GetMapping("/current")
    public Result<String> current() {
        log.info(DateTimeUtils.currentDateTimeString());
        return Result.success(DateTimeUtils.currentDateTimeString());
    }

    /**
     * 刷新缓存
     * 高并发情况下会存在缓存一致性问题
     */
    @GetMapping("/cache/load")
    public Result<Boolean> reloadCache() {
        dictInitializer.init();
        return Result.success();
    }

    /**
     * 获取字典
     */
    @GetMapping("/cache")
    public Result<String> getCache(@RequestParam("groupCode") String groupCode,
                                   @RequestParam("dictCode") String dictCode) {
        return Result.success(DictCache.getDictValue(dictCode, groupCode));
    }

}
