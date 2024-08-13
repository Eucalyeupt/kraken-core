package fun.bigtable.kraken.annotation;

import fun.bigtable.kraken.constant.SensitiveTypeEnum;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 安全字段注解
 * 加在需要加密/解密的方法上
 * 实现自动加密解密
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface EncryptMethod {

    SensitiveTypeEnum type() default SensitiveTypeEnum.MOBILE_PHONE;

    String[] field() default {};
}