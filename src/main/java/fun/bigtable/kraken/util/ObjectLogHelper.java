package fun.bigtable.kraken.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * 对象日志辅助类 -- 会对时间、数字类型自行格式化
 * <p>参考示例</p>
 * <pre>
 *         TelSellTaskEntity new1 = new TelSellTaskEntity();
 *         new1.setId(1L);
 *         new1.setType(TelSellTaskTypeEnums.OIL.getCode());
 *         new1.setCloseTime(new Date());
 *
 *         TelSellTaskEntity old1 = new TelSellTaskEntity();
 *         old1.setId(2L);
 *         old1.setType(TelSellTaskTypeEnums.PREPAY.getCode());
 *         old1.setCloseTime(DateUtil.toDate("2014-01-01 00:00:00"));
 *
 *         ObjectLogHelper<TelSellTaskEntity> helper = ObjectLogHelper.of(new1, old1)
 *                 .appendPrefix("前缀一般是时间")
 *                 .appendUserName("操作人")
 *                 .appendSuffix("后缀可不写")
 *                 .compareObjectProperty(TelSellTaskEntity::getId, "主键")
 *                 .compareObjectProperty(TelSellTaskEntity::getCloseTime, "关闭时间")
 *                 //如果是以下写法，没有声明对象类型，需要主动声明泛型类型
 *                 .compareObjectProperty(f -> TelSellTaskTypeEnums.getByCode(f.getType()).getName(), "类型", TelSellTaskEntity.class)
 *                 .compareObjectProperty(f -> f.getId() + f.getType(), "自定义字段", TelSellTaskEntity.class)
 *                 .compareObjectProperty(TelSellTaskEntity::getCalled, "是否接通");
 *         System.out.println(helper.generateLogStr());
 *         //【前缀一般是时间】【操作人】【修改】【主键】从[2]改为[1];【关闭时间】从[2014-01-01 00:00:00]改为[2024-01-30 22:22:59];【类型】从[司机预付]改为[油];【自定义字段】从[2prepay]改为[1oil];【后缀可不写】
 *     }
 * }</pre>
 *
 * @author 刘乐法
 * @date 2024/1/30 16:34
 */
public class ObjectLogHelper<T> {

    /**
     * 新对象
     */
    private final T             newObj;
    /**
     * 旧对象
     */
    private final T             oldObj;
    /**
     * 存日志
     */
    private final StringBuilder logAppend;
    /**
     * 日志前缀
     */
    private       String        prefix;
    /**
     * 日志操作人
     */
    private       String        userName;
    /**
     * 日志后缀
     */
    private       String        suffix;

    //---------------------------------------------

    /**
     * 设置对象属性改变日志
     *
     * @param getter 对象属性的get方法或者其他自定义方法
     * @param desc   属性描述
     * @param tClass 仅用来不声明getter中泛型T的时候，来声明泛型
     * @param <R>    对象函数返回值泛型
     */
    @SafeVarargs
    public final <R> ObjectLogHelper<T> compareObjectProperty(Function<T, R> getter, String desc, Class<T>... tClass) {
        R newV = getter.apply(newObj);

        if (oldObj == null) {
            logAppend.append(MyFormatUtils.format("【 {} 】[{}];",desc,objectToString(newV)));
        } else {
            R oldV = getter.apply(oldObj);
            if (!Objects.equals(newV, oldV)) {
                logAppend.append(MyFormatUtils.format("【{}】从[{}]改为[{}];", desc, objectToString(oldV), objectToString(newV)));
            }
        }
        return this;
    }



    /**
     * 生成变更日志
     */
    public String generateLogStr() {
        if (StringUtils.isNotEmpty(suffix)) {
            logAppend.append("【").append(suffix).append("】");
        }
        logAppend.insert(0, oldObj == null ? "【新增】" : "【修改】");
        if (StringUtils.isNotEmpty(userName)) {
            logAppend.insert(0, "【" + userName + "】");
        }
        if (StringUtils.isNotEmpty(prefix)) {
            logAppend.insert(0, "【" + prefix + "】");
        }
        return logAppend.toString();
    }

    /**
     * 设置前缀-默认当前时间
     */
    public ObjectLogHelper<T> appendPrefix() {
        this.prefix = DateTimeUtils.currentDateTimeString();
        return this;
    }

    /**
     * 设置前缀
     */
    public ObjectLogHelper<T> appendPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    /**
     * 设置修改人
     */
    public ObjectLogHelper<T> appendUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * 设置后缀
     */
    public ObjectLogHelper<T> appendSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    /**
     * 设置值，按顺序拼接自定义值
     */
    public ObjectLogHelper<T> append(String str) {
        logAppend.append(str);
        return this;
    }

    public static <T> ObjectLogHelper<T> of(T newObj, T oldObj){
        return new ObjectLogHelper<>(newObj, oldObj);
    }

    private ObjectLogHelper(T newObj, T oldObj) {
        this.newObj    = newObj;
        this.oldObj    = oldObj;
        this.logAppend = new StringBuilder();
    }

    //--------------------------------------------------

    private static String objectToString(Object obj) {
        if (obj == null) {
            return Objects.toString(obj);
        }
        if (obj instanceof Iterable<?> collection) {
            List<String> list = new ArrayList<>();
            for (Object o : collection) {
                list.add(objectToStringField(o));
            }
            return StringUtils.join(list, ",");
        } else {
            return objectToStringField(obj);
        }
    }

    private static String objectToStringField(Object obj) {
        if (obj == null) {
            return Objects.toString(obj);
        } else if (obj instanceof Date) {
            return DateTimeUtils.formateDate(DateTimeUtils.formDateToLocalDateTime((Date) obj));
        } else if (obj instanceof LocalDateTime) {
            return DateTimeUtils.formateDate((LocalDateTime) obj);
        } else if (obj instanceof LocalDate) {
            return DateTimeUtils.formateDate((LocalDate) obj);
        } else if (obj instanceof BigDecimal) {
            return ((BigDecimal) obj).toPlainString();
        } else if (obj instanceof Boolean) {
            return Objects.equals(Boolean.TRUE, obj) ? "是" : "否";
        }
        return Objects.toString(obj);
    }

}
