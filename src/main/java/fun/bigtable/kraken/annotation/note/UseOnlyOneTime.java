package fun.bigtable.kraken.annotation.note;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 仅用一次
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface UseOnlyOneTime {
}
