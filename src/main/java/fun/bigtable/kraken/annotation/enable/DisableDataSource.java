package fun.bigtable.kraken.annotation.enable;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.lang.annotation.*;

/**
 * 排除数据源加载
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public @interface DisableDataSource {
}
