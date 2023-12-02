package fun.bigtable.kraken.redis;

import fun.bigtable.kraken.util.DateTimeUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
public class RedisSimpleLock {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    public boolean lock(String lockKey, long lockTime) {
        if (Optional.ofNullable(stringRedisTemplate.hasKey(lockKey)).orElse(false)) {
            return false;
        }
        stringRedisTemplate.opsForValue().set(lockKey, DateTimeUtils.currentDateTimeString());
        stringRedisTemplate.expire(lockKey, lockTime, TimeUnit.SECONDS);

        return true;
    }

    public void unlock(String lockKey){
        stringRedisTemplate.delete(lockKey);
    }

}
