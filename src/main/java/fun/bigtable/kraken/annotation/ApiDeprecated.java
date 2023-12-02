package fun.bigtable.kraken.annotation;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiDeprecated {
    String msg() default StringUtils.EMPTY;
}
