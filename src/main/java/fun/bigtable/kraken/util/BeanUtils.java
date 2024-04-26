package fun.bigtable.kraken.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * bean工具类
 */
public class BeanUtils {

    /**
     * 拷贝特定字段（浅拷贝）
     * @param getter 来源bean的getter
     * @param setter 目标bean的setter
     */
    public static <Value> void copyProperty(Supplier<Value> getter, Consumer<Value> setter) {
        Value apply = getter.get();
        setter.accept(apply);
    }
}
