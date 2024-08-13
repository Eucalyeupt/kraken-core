package fun.bigtable.kraken.annotation.enable;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
