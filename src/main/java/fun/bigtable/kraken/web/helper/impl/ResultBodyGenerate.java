package fun.bigtable.kraken.web.helper.impl;

import fun.bigtable.kraken.bean.Result;
import fun.bigtable.kraken.web.helper.AbsIdlerBodyGenerate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@ConditionalOnMissingBean(AbsIdlerBodyGenerate.class)
@Component
public class ResultBodyGenerate implements AbsIdlerBodyGenerate {

    @Override
    public Object gen(Object bodyData) {
        return Result.success(bodyData);
    }
}
