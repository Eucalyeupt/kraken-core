package fun.bigtable.kraken.query;

import com.yomahub.tlog.context.TLogContext;
import fun.bigtable.kraken.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Optional;
import java.util.Properties;

/**
 * 参数拦截器
 * sql输出增加前缀
 * #sqlId;traceId
 */
@Component
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class ParamInterceptor implements Interceptor {

    private final static Logger logger = LoggerFactory.getLogger(ParamInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        try {
            StatementHandler delegate = (StatementHandler) invocation.getTarget();
            MetaObject metaObject = SystemMetaObject.forObject(delegate);
            String sqlCommandType = Optional.ofNullable(SystemMetaObject.forObject(metaObject.getValue("delegate")).getValue("mappedStatement.sqlCommandType")).orElse(new Object()).toString();
            if(StringUtils.equals(sqlCommandType, "SELECT")){
                String sqlId = Optional.ofNullable(SystemMetaObject.forObject(metaObject.getValue("delegate")).getValue("mappedStatement.id")).orElse(new Object()).toString();
                BoundSql boundSql = delegate.getBoundSql();
                String changeSql = "#sqlId:" + sqlId;
                final String traceId = TLogContext.getTraceId();
                if(!StringUtils.isEmpty(traceId)){
                    changeSql = changeSql + "; traceId:" + traceId;
                }
                changeSql = changeSql + "; " + "\r\n" + boundSql.getSql();
                metaObject.setValue("boundSql.sql", changeSql);
            }
        } catch (BusinessException e){
            throw  e;
        } catch (Exception e) {
            logger.error("ParamInterceptor Exception", e);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}

