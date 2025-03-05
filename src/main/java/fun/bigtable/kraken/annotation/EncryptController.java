package fun.bigtable.kraken.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 加密控制
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface EncryptController {
    /**
     * 是否解密请求参数
     */
    boolean req() default true;

    /**
     * 是否加密返回值
     */
    boolean res() default true;

}
