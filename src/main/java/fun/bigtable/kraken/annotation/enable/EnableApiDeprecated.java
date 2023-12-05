package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.annotation.aspect.ApiDeprecatedAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * 开始启用接口切面
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ApiDeprecatedAspect.class})
public @interface EnableApiDeprecated {
}
