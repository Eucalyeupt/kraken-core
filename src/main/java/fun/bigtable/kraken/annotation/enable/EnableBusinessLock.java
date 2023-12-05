package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.annotation.aspect.BusinessLockAspect;
import fun.bigtable.kraken.redis.RedisSimpleLock;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({BusinessLockAspect.class, RedisSimpleLock.class})
public @interface EnableBusinessLock {
}
