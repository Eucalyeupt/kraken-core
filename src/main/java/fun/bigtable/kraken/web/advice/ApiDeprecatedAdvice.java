package fun.bigtable.kraken.web.advice;

import fun.bigtable.kraken.annotation.ApiDeprecated;
import fun.bigtable.kraken.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 废弃接口通知
 */
@Aspect
@Component
public class ApiDeprecatedAdvice {

    /**
     * 切点
     */
    @Pointcut(value = "@annotation(fun.bigtable.kraken.annotation.ApiDeprecated)")
    public void pointCut() {
    }

    /**
     * 通知
     */
    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) throws BusinessException {
        ApiDeprecated apiDeprecated = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(ApiDeprecated.class);
        String msg = apiDeprecated.msg();
        if (StringUtils.isEmpty(msg)) {
            msg = "该功能已暂停使用，请退出重新登录，或联系运营人员";
        }
        throw BusinessException.error(msg);
    }
}
