package fun.bigtable.kraken.annotation.aspect;

import fun.bigtable.kraken.annotation.BusinessLock;
import fun.bigtable.kraken.exception.BusinessException;
import fun.bigtable.kraken.exception.Type;
import fun.bigtable.kraken.redis.RedisSimpleLock;
import fun.bigtable.kraken.util.SpelUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 业务锁切面
 */
@Aspect
@Component
public class BusinessLockAspect {

    private static final Logger log = LoggerFactory.getLogger(BusinessLockAspect.class);

    @Resource
    RedisSimpleLock redisSimpleLock;

    @Around(value = "@annotation(businessLock)")
    public Object lock(ProceedingJoinPoint point, BusinessLock businessLock) throws Throwable {
        String businessNo = getBusinessNo(point);
        String lockKey = makeLockKey("lock", businessNo, businessLock.lockKeySufFix());
        long lockTime = businessLock.lockTime();
        if (!redisSimpleLock.lock(lockKey, lockTime)) {
            log.warn("Business Lock Failed, businessNo:{}", businessNo);
            throw new BusinessException(Type.FAIL_INFO, "业务处理中，请稍后再试");
        }
        try {
            return point.proceed();
        } finally {
            redisSimpleLock.unlock(lockKey);
        }
    }

    /**
     * 获取业务编码
     * 用于构建lockKey，lockValue
     *
     * @param joinPoint 切点
     * @return requestNo
     */
    private String getBusinessNo(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Object target = joinPoint.getTarget();
        Object[] arguments = joinPoint.getArgs();
        BusinessLock annotation = AnnotationUtils.findAnnotation(targetMethod, BusinessLock.class);
        String spel = null;
        if (annotation != null) {
            spel = annotation.sPel();
        }
        return SpelUtils.parse(target, spel, targetMethod, arguments);
    }

    public String makeLockKey(String... keys) {
        return StringUtils.join(Arrays.asList(keys), LOCK_KEY_SEPARATOR);
    }

    private static final String LOCK_KEY_SEPARATOR = ":";


}
