package fun.bigtable.kraken.annotation.aspect;

import fun.bigtable.kraken.annotation.ApiDeprecated;
import fun.bigtable.kraken.exception.BusinessException;
import fun.bigtable.kraken.exception.Type;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApiDeprecatedAspect {

    @Pointcut(value = "@annotation(fun.bigtable.kraken.annotation.ApiDeprecated)")
    public void pointCut(){}

    @Before(value="pointCut()")
    public void before(JoinPoint joinPoint) throws BusinessException {
        ApiDeprecated apiDeprecated = ((MethodSignature)joinPoint.getSignature()).getMethod().getAnnotation(ApiDeprecated.class);
        String msg = apiDeprecated.msg();
        if (StringUtils.isEmpty(msg)){
            msg = "该功能已暂停使用，请退出重新登录，或联系运营人员";
        }
        throw new BusinessException(Type.FAIL_INFO,msg);
    }
}
