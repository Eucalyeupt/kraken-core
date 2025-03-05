package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.dict.DictInitializer;
import fun.bigtable.kraken.dict.config.DictConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启用字典缓存
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DictInitializer.class, DictConfig.class})
public @interface EnableDictCache {
}
