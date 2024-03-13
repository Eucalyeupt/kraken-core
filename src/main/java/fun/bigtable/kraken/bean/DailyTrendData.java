package fun.bigtable.kraken.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 日期趋势数据-天
 */
public class DailyTrendData implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 业务无关自增主键
     */
    private Long id;


    /**
     * 扩展信息
     */
    private String extendMsg;

    /**
     * 类型
     * @see Type
     *
     */
    private Integer type;

    /**
     * 日期
     */
    private String day;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 数据
     */
    private BigDecimal data;

    public enum Type {

        OTHER(-1, "未知",""),

        ;
        private final Integer code;

        private final String name;

        private final String desc;


        public static Type getByCode(int code) {
            for (Type value : Type.values()) {
                if (Objects.equals(code, value.code)) {
                    return value;
                }
            }
            return OTHER;
        }


        Type(Integer code, String name, String desc) {
            this.code = code;
            this.name = name;
            this.desc = desc;
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


    public BigDecimal getData() {
        return data;
    }

    public void setData(BigDecimal data) {
        this.data = data;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public String getExtendMsg() {
        return extendMsg;
    }

    public void setExtendMsg(String extendMsg) {
        this.extendMsg = extendMsg;
    }
}