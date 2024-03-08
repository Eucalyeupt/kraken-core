package fun.bigtable.kraken.mp;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import fun.bigtable.kraken.session.IGetSession;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * 填充创建时间 创建人等
 *
 * @author 刘乐法
 * @date 2023/11/17 11:39
 */

@ConditionalOnClass(MetaObjectHandler.class)
@ConditionalOnBean
@Component
public class DefaultDBFieldHandler implements MetaObjectHandler {

    @Autowired
    IGetSession IGetSession;

    private static final Logger log = LoggerFactory.getLogger(DefaultDBFieldHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        // 可以通过 getFieldValByName()方法判断
        // Object modifyTime = getFieldValByName("updateTime", metaObject);
        if (metaObject.getOriginalObject() instanceof BaseEntity) {
            // 获取当前用户信息
            long loginUser = 0L;
            try {
                loginUser = IGetSession.getUserId();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
            if (Objects.isNull(getFieldValByName("createTime", metaObject))) {
                this.setFieldValByName("createTime", new Date(), metaObject);
            }
            if (Objects.isNull(getFieldValByName("createId", metaObject))) {
                this.setFieldValByName("createId", loginUser, metaObject);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.getOriginalObject() instanceof BaseEntity) {
            // 更新时间为空，则以当前时间为更新时间
            Object modifyTime = getFieldValByName("updateTime", metaObject);
            if (Objects.isNull(modifyTime)) {
                setFieldValByName("updateTime", new Date(), metaObject);
            }
            // 当前登录用户不为空，更新人为空，则当前登录用户为更新人
            Object modifier = getFieldValByName("updateId", metaObject);
            long loginUser = 0L;
            try {
                loginUser =  IGetSession.getUserId();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
            if (Objects.isNull(modifier)) {
                setFieldValByName("updateId", loginUser, metaObject);
            }
        }
    }
}
