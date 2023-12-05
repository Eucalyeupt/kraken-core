package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.dict.DictInitializer;
import fun.bigtable.kraken.dict.config.DictConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DictInitializer.class, DictConfig.class})
public @interface EnableDictCache {
}
