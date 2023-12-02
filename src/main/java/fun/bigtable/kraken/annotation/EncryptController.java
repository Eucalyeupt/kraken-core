package fun.bigtable.kraken.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface EncryptController {
    /**
     * 是否解密请求参数
     * @return
     */
    boolean req() default true;

    /**
     * 是否加密返回值
     * @return
     */
    boolean res() default true;

}
