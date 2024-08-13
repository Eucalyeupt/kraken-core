package fun.bigtable.kraken.util.offset.bean;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class AbstractConsume implements Comparable<AbstractConsume>{

    /**
     * 获取余量
     */
    public abstract BigDecimal getRestCnt();

    /**
     * 设置核销后余量
     */
    public abstract void setRestCnt(BigDecimal restCnt);

    /**
     * 获取核销状态
     *
     * @see ConsumeState
     */
    public abstract Integer getConsumeState();

    /**
     * 设置核销状态
     *
     * @see ConsumeState
     */
    public abstract void setConsumeState(Integer consumeState);

    /**
     * 获取排序字段
     */
    public abstract Comparable getSort();

    public boolean canResume(){
        return !ConsumeState.ALL_CONSUMED.getCode().equals(getConsumeState());
    }

    @Override
    public int compareTo(@NotNull AbstractConsume o) {
        return getSort().compareTo(o.getSort());
    }

    public enum ConsumeState {
        UN_CONSUME(1, "未消费"),
        CONSUMED(2, "已消费-有余额"),
        ALL_CONSUMED(3, "已消费-无余额"),

        OTHER(-1, "未知"),

        ;
        private final Integer code;

        private final String name;


        public static ConsumeState getByCode(int code) {
            for (ConsumeState value : ConsumeState.values()) {
                if (Objects.equals(code, value.code)) {
                    return value;
                }
            }
            return OTHER;
        }

        ConsumeState(Integer code, String name) {
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
