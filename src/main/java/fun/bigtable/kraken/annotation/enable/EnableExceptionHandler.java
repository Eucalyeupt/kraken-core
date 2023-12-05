package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.exception.GlobalDefaultExceptionHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({GlobalDefaultExceptionHandler.class})
public @interface EnableExceptionHandler {
}
