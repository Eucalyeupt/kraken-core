package fun.bigtable.kraken.dict;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DictCache {
    private final static String sysConfigKey = "sysConfig";

    private static Map<String, Map<String, Dictionary>> dictGroupSet = new HashMap<String, Map<String, Dictionary>>();

    public static void setDictGroupSet(Map<String, Map<String, Dictionary>> dictGroupSet) {
        DictCache.dictGroupSet = dictGroupSet;
    }

    /**
     * 获取字典值
     */
    public static String getDictValue(String dictCode, String groupCode) {
        Dictionary dict = getDict(dictCode, groupCode);
        if (dict == null) return "";
        return dict.getValue();
    }

    public static Dictionary getDict(String dictCode, String groupCode) {
        if (StringUtils.isEmpty(dictCode))
            return null;
        Map<String, Dictionary> dictGroup = dictGroupSet.get(groupCode);
        if (dictGroup == null) return null;
        if (dictGroup.get(dictCode) == null) return null;
        return dictGroup.get(dictCode);
    }

    public static String getDictValueSysSet(String dictCode) {
        return getDictValue(dictCode, "SysSet");
    }

    /**
     * 获取字典值
     */
    public static Collection<Dictionary> getDictByGroupCode(String groupCode) {
        Map<String, Dictionary> dictGroup = dictGroupSet.get(groupCode);
        if (dictGroup == null) return null;
        return dictGroup.values();
    }

    /**
     * 获取系统配置
     */
    public static String getSysConfig(String code) {
        return getDictValue(code, sysConfigKey);
    }


    /**
     * 清空缓存
     */
    public static void clear() {
        dictGroupSet.clear();
    }
}
