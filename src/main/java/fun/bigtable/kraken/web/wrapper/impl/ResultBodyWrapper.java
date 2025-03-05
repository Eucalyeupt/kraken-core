package fun.bigtable.kraken.web.wrapper.impl;

import fun.bigtable.kraken.bean.Result;
import fun.bigtable.kraken.web.wrapper.AbsIdlerBodyWrapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@ConditionalOnMissingBean(AbsIdlerBodyWrapper.class)
@Component
public class ResultBodyWrapper implements AbsIdlerBodyWrapper {

    @Override
    public Object gen(Object bodyData) {
        return Result.success(bodyData);
    }
}
