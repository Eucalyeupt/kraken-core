package fun.bigtable.kraken.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * DB工具
 */
public class DBUtils {

    /**
     * 批量插入
     *
     * @param consumer 批量插入方法
     * @param collection 批量插入的对象
     * @param <T> 数据类
     * @param <C> Collection
     */
    public static <T, C extends Collection<T>> void batchInsert(Consumer<C> consumer, C collection) {
        if(CollectionUtils.isEmpty(collection)){
            return;
        }

        consumer.accept(collection);
    }

}
