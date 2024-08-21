package fun.bigtable.kraken.pre;


import fun.bigtable.kraken.exception.BusinessAssert;
import fun.bigtable.kraken.pre.dto.CheckContext;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 检查器
 */
public abstract class IPreChecker<T extends CheckContext, D extends ICheckBizData> {

    /**
     * 设置上下文，应该对下面check方法需要所有变量进行赋值
     * TODO 还是会有重复赋值的问题，不同checker之间也会有交叉取值的情况
     */
    public abstract void setContext(T content, D checkBiz);

    /**
     * 检查，
     */
    public T exec(T content, D checkBiz) {
        for (Object data : getMustCheck().stream().map(func -> func.apply(content)).collect(Collectors.toList())) {
            BusinessAssert.ifNull(data, "上下文中缺少必要参数");
        }
        return check(content, checkBiz);
    }

    /**
     * 检查，不要在此处对上下文和原始业务数据赋值
     */
    public abstract T check(T content, D checkBiz);

    /**
     * 提前检查上下文数据
     */
    public List<Function<T, Object>> getMustCheck() {
        return Collections.emptyList();
    }

    /**
     * 检查业务
     */
    public abstract PreCheckerType type();

    public enum PreCheckerType {

        VAS_ORG_ASSIGN_OUL(1, "货主配油"),

        OTHER(-1, "未知"),

        ;
        private final Integer code;

        private final String name;


        public static PreCheckerType getByCode(int code) {
            for (PreCheckerType value : PreCheckerType.values()) {
                if (Objects.equals(code, value.code)) {
                    return value;
                }
            }
            return OTHER;
        }

        PreCheckerType(Integer code, String name) {
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
