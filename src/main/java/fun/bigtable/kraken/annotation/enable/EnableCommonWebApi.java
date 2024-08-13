package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.controller.CommonController;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 引入CommonController中声明的请求
 *
 * @see CommonController
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CommonController.class)
public @interface EnableCommonWebApi {
}
