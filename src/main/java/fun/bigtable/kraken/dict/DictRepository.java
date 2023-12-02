package fun.bigtable.kraken.dict;

import java.util.List;

public interface DictRepository {

    /**
     * 获取所有数据字典
     */
    List<Dictionary> selectDictionaryAll();
}
