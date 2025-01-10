package fun.bigtable.kraken.constant;



import fun.bigtable.kraken.exception.BusinessAssert;

import java.util.Objects;

/**
 * 枚举继承用接口 可快速判断枚举值并报错
 */
public interface IEnum {

    Integer getCode();

    String getName();

    default void check(Integer code){
        BusinessAssert.ifFalse(Objects.equals(code, getCode()),"非"+ getName());
    }
}
