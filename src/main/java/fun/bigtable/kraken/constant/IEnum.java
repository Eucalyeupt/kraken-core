package fun.bigtable.kraken.constant;


import fun.bigtable.kraken.exception.BusinessAssert;

import java.util.Objects;

public interface IEnum {

    Integer getCode();

    String getName();

    default void check(Integer code){
        BusinessAssert.ifFalse(Objects.equals(code, getCode()),"非"+ getName());
    }
}
