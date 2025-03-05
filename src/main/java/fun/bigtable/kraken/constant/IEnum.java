package fun.bigtable.kraken.constant;


import fun.bigtable.kraken.exception.BusinessAssert;

import java.util.Objects;

/**
 * 枚举继承用接口 可快速判断枚举值并报错
 */
public interface IEnum {

    /**
     * code
     */
    Integer getCode();

    /**
     * name
     */
    String getName();

    /**
     * 检查是否相同
     *
     * @param code code
     */
    default void check(Integer code) {
        BusinessAssert.ifFalse(Objects.equals(code, getCode()), "非" + getName());
    }

    /**
     * 枚举值是否相同
     *
     * @param code code
     * @return 是否相同
     */
    default boolean equals(Integer code) {
        return Objects.equals(code, getCode());
    }
}
