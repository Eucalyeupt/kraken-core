package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.web.advice.IdlerControllerAdvice;
import fun.bigtable.kraken.web.wrapper.impl.ResultBodyWrapper;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启用懒狗controller
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({IdlerControllerAdvice.class, ResultBodyWrapper.class})
public @interface EnableIdlerController {
}
