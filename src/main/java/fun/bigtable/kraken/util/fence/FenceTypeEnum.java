package fun.bigtable.kraken.util.fence;

import java.util.Objects;

public enum FenceTypeEnum {

    ROUND(1,"圆形围栏"),
    CUSTOM(2,"多边形围栏"),
    AREA(3,"区域围栏"),
    ERROR(4,"错误的类型");

    private final int code;

    private final String name;

    public static FenceTypeEnum getTypeByCode(int code){
        for (FenceTypeEnum value : FenceTypeEnum.values()) {
            if(Objects.equals(code,value.code)){
                return value;
            }
        }
        return ERROR;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    FenceTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

}
