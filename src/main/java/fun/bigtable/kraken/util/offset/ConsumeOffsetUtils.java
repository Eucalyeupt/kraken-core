package fun.bigtable.kraken.util.offset;


import fun.bigtable.kraken.exception.BusinessAssert;
import fun.bigtable.kraken.util.BeanUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * 核销工具类
 */
public class ConsumeOffsetUtils {


    public static <T extends AbstractConsume> List<T> consume(List<T> consumes, BigDecimal toConsume) {

        BusinessAssert.checkMustParam(toConsume);
        BusinessAssert.ifCollectionEmpty(consumes, "待核销不可为空");

        List<T> copyList = BeanUtils.copyListByJson(consumes);

        // 去除所有已消费的
        copyList.removeIf(AbstractConsume::canResume);

        // 重排
        copyList.sort(AbstractConsume::compareTo);

        BigDecimal start = BigDecimal.ZERO;

        for (T consume : copyList) {

            BigDecimal add = start.add(consume.getRestCnt());

            // 小于，全部核销
            if (add.compareTo(toConsume) < 0) {
                consume.setRestCnt(BigDecimal.ZERO);
                consume.setConsumeState(AbstractConsume.ConsumeState.ALL_CONSUMED.getCode());
            }
            // 等于全部核销，结束
            else if (add.compareTo(toConsume) == 0) {
                consume.setRestCnt(BigDecimal.ZERO);
                consume.setConsumeState(AbstractConsume.ConsumeState.ALL_CONSUMED.getCode());
                break;
            }
            // 大于，部分核销，结束
            else {
                consume.setRestCnt(add.subtract(toConsume));
                consume.setConsumeState(AbstractConsume.ConsumeState.CONSUMED.getCode());
                break;
            }
        }

        BusinessAssert.ifFalse(toConsume.compareTo(start) == 0, "核销余量不足");

        return copyList;
    }


    private ConsumeOffsetUtils() {

    }
}
