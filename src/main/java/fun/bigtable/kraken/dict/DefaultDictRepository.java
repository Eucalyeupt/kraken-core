package fun.bigtable.kraken.dict;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultDictRepository implements DictRepository{

    /**
     * 获取所有数据字典
     */
    @Override
    public List<Dictionary> selectDictionaryAll() {
        return new ArrayList<>();
    }
}
