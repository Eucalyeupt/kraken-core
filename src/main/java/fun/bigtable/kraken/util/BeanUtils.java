package fun.bigtable.kraken.util;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * bean工具类
 */
public class BeanUtils {

    /**
     * 拷贝特定字段（浅拷贝）
     *
     * @param getter 来源bean的getter
     * @param setter 目标bean的setter
     */
    public static <Value> void copyProperty(Supplier<Value> getter, Consumer<Value> setter) {
        Value apply = getter.get();
        setter.accept(apply);
    }

    /**
     * 使用json深拷贝List
     */
    public static <T> List<T> copyListByJson(List<T> list) {
        List<T> newList = new ArrayList<>();

        return JsonUtils.parserCustom(JsonUtils.toJson(list), new TypeToken<List<T>>() {
        });
    }
}
