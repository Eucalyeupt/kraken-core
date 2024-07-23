package fun.bigtable.kraken.annotation.note;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface BusinessNote {

    /**
     * 业务类型
     */
    BusinessSubType value();

    /**
     * 注释
     */
    String desc() default "";


    enum BusinessSubType {

        OIL(1, "", BusinessType.VAS),


        OTHER(-1, "未知", BusinessType.OTHER),

        ;
        private final Integer code;

        private final String name;

        private final BusinessType businessType;


        public static BusinessSubType getByCode(int code) {
            for (BusinessSubType value : BusinessSubType.values()) {
                if (Objects.equals(code, value.code)) {
                    return value;
                }
            }
            return OTHER;
        }

        BusinessSubType(Integer code, String name, BusinessType businessType) {
            this.code = code;
            this.name = name;
            this.businessType = businessType;
        }

        public BusinessType getBusinessType() {
            return businessType;
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

    }


    enum BusinessType {

        VAS(1, "增值服务"),

        OTHER(-1, "未知"),

        ;
        private final Integer code;

        private final String name;


        public static BusinessType getByCode(int code) {
            for (BusinessType value : BusinessType.values()) {
                if (Objects.equals(code, value.code)) {
                    return value;
                }
            }
            return OTHER;
        }

        BusinessType(Integer code, String name) {
            this.code = code;
            this.name = name;
        }


        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

    }

}
