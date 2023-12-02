package fun.bigtable.kraken.constant;

import java.util.Optional;

/**
 * 是否枚举
 */
public enum YesNoEnum {

    OTHER(-1, ""),

    NO(0, "否"),

    YES(1, "是");

    private Integer code;
    private String desc;

    YesNoEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static YesNoEnum getEnum(Integer code) {
        if (code == null) {
            return OTHER;
        }
        for (YesNoEnum ynEnum : YesNoEnum.values()) {
            if (ynEnum.code.equals(code)) {
                return ynEnum;
            }
        }
        return OTHER;
    }

    public static Boolean isYes(Integer code){
        code = Optional.ofNullable(code).orElse(YesNoEnum.NO.getCode());
        return YesNoEnum.YES.getCode().equals(code);
    }

    public static Boolean isNo(Integer code){
        code = Optional.ofNullable(code).orElse(YesNoEnum.YES.getCode());
        return YesNoEnum.NO.getCode().equals(code);
    }

    public static YesNoEnum fromBool(boolean criteria) {
        return criteria ? YES : NO;
    }
}
