package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.exception.GlobalDefaultExceptionHandler;
import fun.bigtable.kraken.web.advice.IdlerControllerAdvice;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({IdlerControllerAdvice.class})
public @interface EnableIdlerController {
}
