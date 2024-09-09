package fun.bigtable.kraken.annotation.enable;

import fun.bigtable.kraken.controller.CommonController;
import fun.bigtable.kraken.pre.ContextCheckHelper;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ContextCheckHelper.class)
public @interface EnableContextCheckHelper {
}
