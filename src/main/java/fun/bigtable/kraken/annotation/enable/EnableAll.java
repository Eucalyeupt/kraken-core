package fun.bigtable.kraken.annotation.enable;

import java.lang.annotation.*;

/**
 * 引入所有启用注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableApiDeprecated
@EnableBusinessLock
@EnableDictCache
@EnableExceptionHandler
@DisableDataSource
@EnableCommonWebApi
public @interface EnableAll {
}
