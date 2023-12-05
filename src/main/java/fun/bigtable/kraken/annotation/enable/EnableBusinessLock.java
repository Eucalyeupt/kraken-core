package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.annotation.aspect.BusinessLockAspect;
import fun.bigtable.kraken.redis.RedisSimpleLock;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 简易的业务锁，使用BusinessLock注解锁定
 *
 * @see fun.bigtable.kraken.annotation.BusinessLock
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({BusinessLockAspect.class, RedisSimpleLock.class})
public @interface EnableBusinessLock {
}
