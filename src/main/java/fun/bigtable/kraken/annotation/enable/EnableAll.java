package fun.bigtable.kraken.annotation.enable;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableApiDeprecated
@EnableBusinessLock
@EnableDictCache
@EnableExceptionHandler
@DisableDataSource
public @interface EnableAll {
}
