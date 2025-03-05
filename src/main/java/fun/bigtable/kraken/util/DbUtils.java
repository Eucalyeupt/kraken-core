package fun.bigtable.kraken.util;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * 数据库工具类
 */
public abstract class DbUtils {

    private static final Logger log = LoggerFactory.getLogger(DbUtils.class);

    /**
     * 事务后执行
     */
    public static <T> void syncBehindTransaction(Consumer<T> consumer, T data) {
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                try {
                    consumer.accept(data);
                } catch (Exception e) {
                    log.error("执行失败");
                }
            }
        });
    }

    /**
     * 批量插入
     *
     * @param consumer   批量插入方法
     * @param collection 批量插入的对象
     * @param <T>        数据类
     * @param <C>        Collection
     */
    public static <T, C extends Collection<T>> void batchInsert(Consumer<C> consumer, C collection) {
        if (CollectionUtils.isEmpty(collection)) {
            return;
        }

        consumer.accept(collection);
    }
}
