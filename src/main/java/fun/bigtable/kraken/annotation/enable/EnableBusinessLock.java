package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.annotation.aspect.BusinessLockAspect;
import fun.bigtable.kraken.redis.RedisSimpleLock;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({BusinessLockAspect.class, RedisSimpleLock.class})
public @interface EnableBusinessLock {
}
