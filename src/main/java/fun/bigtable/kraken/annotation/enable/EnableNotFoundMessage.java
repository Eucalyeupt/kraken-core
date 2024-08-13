package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.web.advice.ErrorPageAdvice;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 404返回改为标准输出格式
 * 此处较为暴力直接排除了ErrorMvcAutoConfiguration
 *
 * @see ErrorPageAdvice
 */
@Deprecated
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ErrorPageAdvice.class})
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
public @interface EnableNotFoundMessage {
}
