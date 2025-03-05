package fun.bigtable.kraken.pre;

import fun.bigtable.kraken.pre.dto.CheckContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 业务检查器
 */
public class ContextCheckHelper {

    List<IPreChecker<?, ?>> checkers;

    public ContextCheckHelper(List<IPreChecker<?, ?>> checkers) {
        this.checkers = checkers;
    }

    private static final Logger log = LoggerFactory.getLogger(ContextCheckHelper.class);

    public <C extends CheckContext, D extends ICheckBizData> void createContextAndCheck(IPreChecker.PreCheckerType checkerType, D iCheckBizData, C generate) {
        List<IPreChecker<C, D>> collect = checkers.stream()
                .filter(check -> check.type().equals(checkerType))
                .map(check -> (IPreChecker<C, D>) check)
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            log.warn("未找到关联的检查器 {} 业务ID {}", checkerType.getName(), iCheckBizData.getId());
            return;
        }

        for (IPreChecker<C, D> preChecker : collect) {
            preChecker.setContext(generate, iCheckBizData);
        }

        for (IPreChecker<C, D> preChecker : collect) {
            preChecker.exec(generate, iCheckBizData);
        }

    }
}
