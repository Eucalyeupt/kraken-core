package fun.bigtable.kraken.consume.bean;

import fun.bigtable.kraken.util.offset.bean.AbstractConsume;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class Consume extends AbstractConsume {

    private BigDecimal restCnt;

    private Integer consumeState;

    private Long id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public BigDecimal getRestCnt() {
        return restCnt;
    }

    @Override
    public void setRestCnt(BigDecimal restCnt) {
        this.restCnt = restCnt;
    }

    @Override
    public Integer getConsumeState() {
        return consumeState;
    }

    @Override
    public void setConsumeState(Integer consumeState) {
        this.consumeState = consumeState;
    }

    @Override
    public Long getSort() {
        return id;
    }
}
