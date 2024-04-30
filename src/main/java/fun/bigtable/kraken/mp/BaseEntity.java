package fun.bigtable.kraken.mp;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * mybatisplus基础父类
 *
 * @author 刘乐法
 * @date 2023/11/17 11:35
 */
public abstract class BaseEntity implements Serializable {

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    protected Date createTime;
    /**
     * 最后更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    protected Date updateTime;
    /**
     * 创建者，目前使用 SysUser 的 id 编号
     */
    @TableField(fill = FieldFill.INSERT)
    protected Long createId;
    /**
     * 更新者，目前使用 SysUser 的 id 编号
     */
    @TableField(fill = FieldFill.UPDATE)
    protected Long updateId;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }
}