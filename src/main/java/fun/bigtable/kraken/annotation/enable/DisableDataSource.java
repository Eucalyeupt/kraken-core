package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.exception.GlobalDefaultExceptionHandler;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public @interface DisableDataSource {
}
