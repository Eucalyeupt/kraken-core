package fun.bigtable.kraken.dict;

import fun.bigtable.kraken.init.AbstractInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DictInitializer extends AbstractInitializer {

    private static final Logger log = LoggerFactory.getLogger(DictInitializer.class);

    @Resource
    DictRepository dictRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void init() {

        log.warn("开启字典，实现fun.bigtable.kraken.dict.DictRepository接口");

        log.info("++++++++++++++++++　　数据字典开始加载　　+++++++++++++++++++++");
        DictCache.clear();
        List<Dictionary> allDict = dictRepository.selectDictionaryAll();

        Map<String, Map<String, Dictionary>> dictGroupSet = new HashMap<String, Map<String, Dictionary>>();

        for (Dictionary dict : allDict) {
            Map<String, Dictionary> dicMapGroup = dictGroupSet.get(dict.getGroup());
            if (dictGroupSet.get(dict.getGroup()) == null) {
                dicMapGroup = new HashMap<>();
            }
            dicMapGroup.put(dict.getCode(), dict);
            dictGroupSet.put(dict.getGroup(), dicMapGroup);
        }
        DictCache.setDictGroupSet(dictGroupSet);
        log.info("++++++++++++++++++　　数据字典完成加载 共{}项　　+++++++++++++++++++++",dictGroupSet.size());
    }

    public String module() {
        return "字典";
    }
}
