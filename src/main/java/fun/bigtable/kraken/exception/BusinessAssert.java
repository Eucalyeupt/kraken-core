package fun.bigtable.kraken.exception;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * 断言工具类
 */
public class BusinessAssert {


    /**
     * 表达式为真则抛出异常
     */
    public static void ifTrue(boolean expression, String errorMsg) throws BusinessException {
        if (expression) {
            throw new BusinessException(Type.FAIL_INFO, errorMsg);
        }
    }

    public static void ifFalse(boolean expression, String errorMsg) throws BusinessException {
        if (!expression) {
            throw new BusinessException(Type.FAIL_INFO, errorMsg);
        }
    }

    /**
     * 集合为空则抛出异常
     */
    public static void ifCollectionEmpty(Collection collection, String errorMsg) throws BusinessException {
        ifTrue(CollectionUtils.isEmpty(collection), errorMsg);
    }

    /**
     * 对象为空则抛出异常
     */
    public static void ifNull(Object object, String errorMsg) throws BusinessException {
        ifTrue(Objects.isNull(object), errorMsg);
    }

    /**
     * 为空抛出异常
     *
     * @param object   对象
     * @param errorMsg 错位描述
     * @throws BusinessException 业务异常
     */
    public static void ifEmpty(Object object, String errorMsg) throws BusinessException {
        ifTrue(ObjectUtils.isEmpty(object), errorMsg);
    }

    public static void collectionSizeGtOne(Collection collection, String errorMsg) throws BusinessException {
        ifTrue(collection.size() > 1, errorMsg);
    }

    /**
     * 所有参数不能为null
     * <b>错误信息在前<b/>
     */
    public static void allNonNull(String errMsg, Object... check) throws BusinessException {
        ifTrue(Objects.isNull(check) || Arrays.stream(check).anyMatch(Objects::isNull), errMsg);
    }

    /**
     * 参数不为空
     */
    public static void paramNotNull(Object param) throws BusinessException {
        if(Objects.isNull(param)){
            throw new BusinessException(Type.PARA_NULL);
        }
    }

    public static void ifTrue(boolean expression, String errorMsg, Type errorType) throws BusinessException {
        if (expression) {
            throw new BusinessException(errorType, errorMsg);
        }
    }

    public static void checkMustParam(Object... object) throws BusinessException {
        allNonNull("必要参数未传",object);
    }
}
