package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.web.advice.ApiDeprecatedAdvice;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 启用API弃用
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ApiDeprecatedAdvice.class})
public @interface EnableApiDeprecated {
}
