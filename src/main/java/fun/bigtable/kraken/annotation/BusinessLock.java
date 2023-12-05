package fun.bigtable.kraken.annotation;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * 业务锁
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Order(-1)
public @interface BusinessLock {

    /**
     * 业务锁流水号spel
     * eg:{@code #object.filed} or {@code #object.filed + #object.filed}
     */
    String sPel() default "";

    /**
     * 业务锁key 后缀
     */
    String lockKeySufFix() default "";

    /**
     * 业务锁锁定时间， 默认30s
     * -1时，不设置失效时间
     */
    long lockTime() default 30;


}
