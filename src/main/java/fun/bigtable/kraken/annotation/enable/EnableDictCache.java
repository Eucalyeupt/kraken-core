package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.controller.CommonController;
import fun.bigtable.kraken.dict.DefaultDictRepository;
import fun.bigtable.kraken.dict.DictInitializer;
import fun.bigtable.kraken.dict.DictRepository;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用字典，可使用DictCache
 *
 * @see fun.bigtable.kraken.dict.DictCache
 * @see DictRepository
 * @see fun.bigtable.kraken.controller.CommonController#getCache(String, String)
 * @see CommonController#reloadCache()
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DictInitializer.class, DefaultDictRepository.class})
public @interface EnableDictCache {
}
