package fun.bigtable.kraken.lock;

import fun.bigtable.kraken.util.DateTimeUtils;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 简单redis锁
 */
@Component
public class RedisSimpleLock {

    StringRedisTemplate stringRedisTemplate;

    public RedisSimpleLock(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 加锁
     *
     * @param lockKey  锁key
     * @param lockTime 锁时间
     */
    public boolean lock(String lockKey, long lockTime) {
        if (Optional.ofNullable(stringRedisTemplate.hasKey(lockKey)).orElse(false)) {
            return false;
        }
        stringRedisTemplate.opsForValue().set(lockKey, DateTimeUtils.currentDateTimeString());
        stringRedisTemplate.expire(lockKey, lockTime, TimeUnit.SECONDS);

        return true;
    }

    /**
     * 解锁
     *
     * @param lockKey 锁key
     */
    public void unlock(String lockKey) {
        stringRedisTemplate.delete(lockKey);
    }

}
