package fun.bigtable.kraken.util.fence;

import java.util.Objects;

public enum FenceAlarmTypeEnum {
    GET_IN(1, "入围栏告警", "fence_in"),
    GET_OUT(2, "出围栏告警", "fence_out"),
    GET_THROUGH(3, "出入围栏告警", "fence_through"),
    ERROR(0, "错误类型", "error");

    private final int code;

    private final String name;

    private final String type;

    public static FenceAlarmTypeEnum getByCode(int code) {
        for (FenceAlarmTypeEnum value : FenceAlarmTypeEnum.values()) {
            if (Objects.equals(code, value.code)) {
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

    public String getType() {
        return type;
    }

    FenceAlarmTypeEnum(int code, String name, String type) {
        this.code = code;
        this.name = name;
        this.type = type;
    }
}
