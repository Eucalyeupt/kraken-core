package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.controller.CommonController;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

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
