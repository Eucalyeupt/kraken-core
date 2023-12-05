package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.web.ApiDeprecatedAdvice;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * 弃用接口注解
 * 所有使用了ApiDeprecated注解的接口将重定义返回
 *
 * @see fun.bigtable.kraken.annotation.ApiDeprecated
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ApiDeprecatedAdvice.class})
public @interface EnableApiDeprecated {
}
