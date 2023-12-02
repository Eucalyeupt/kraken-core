package fun.bigtable.kraken.util.fence;

import com.fasterxml.jackson.annotation.JsonFormat;
import fun.bigtable.kraken.note.RequestField;
import fun.bigtable.kraken.note.ResponseField;

import java.util.Date;


public class WarningRuleFence  {

    /**
     * '业务无关自增主键'
     */
    private Long id;

    private Long orgId;

    /**
     * '围栏名称'
     */
    private String ruleName;
    /**
     * '告警类型'
     *
     * @see FenceAlarmTypeEnum
     */
    private Integer alarmType;
    /**
     * '创建时间'
     */
    private Date createTime;
    /**
     * '创建人'
     */
    private String creator;
    /**
     * '是否在用'
     */
    private Boolean inUse;
    /**
     * '围栏类型'
     * @see FenceTypeEnum
     */
    private Integer fenceType;
    /**
     * '半径 仅当圆形围栏时有值 单位  米'
     */
    private Integer radius;
    /**
     * '边缘 geojson格式 仅当多边形围栏时有值'
     */
    private String fenceBorder;
    /**
     * '区域名称 仅当区域围栏时有值'
     */
    private String areaName;
    /**
     * '区域行政代码 仅当区域围栏时有值'
     */
    private String areaCode;

    /**
     * 上次更新时间
     */
    private Date updateTime;

    /**
     * 更新人姓名
     */
    private String updateUser;

    @RequestField
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date createTimeQueryStart;

    @RequestField
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date createTimeQueryEnd;

    @RequestField
    private String plateNum;

    @RequestField
    private String boxImei;

    /**
     * 绑定设备数
     */
    @ResponseField
    private Integer bindNum;

    /**
     * 圆形围栏中心点
     */
    private String centerPosition;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getCenterPosition() {
        return centerPosition;
    }

    public void setCenterPosition(String centerPosition) {
        this.centerPosition = centerPosition;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Integer getBindNum() {
        return bindNum;
    }

    public void setBindNum(Integer bindNum) {
        this.bindNum = bindNum;
    }

    public Date getCreateTimeQueryStart() {
        return createTimeQueryStart;
    }

    public void setCreateTimeQueryStart(Date createTimeQueryStart) {
        this.createTimeQueryStart = createTimeQueryStart;
    }

    public Date getCreateTimeQueryEnd() {
        return createTimeQueryEnd;
    }

    public void setCreateTimeQueryEnd(Date createTimeQueryEnd) {
        this.createTimeQueryEnd = createTimeQueryEnd;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getBoxImei() {
        return boxImei;
    }

    public void setBoxImei(String boxImei) {
        this.boxImei = boxImei;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleName() {
        return this.ruleName;
    }

    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    public Integer getAlarmType() {
        return this.alarmType;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setInUse(Boolean inUse) {
        this.inUse = inUse;
    }

    public Boolean getInUse() {
        return this.inUse;
    }

    public void setFenceType(Integer fenceType) {
        this.fenceType = fenceType;
    }

    public Integer getFenceType() {
        return this.fenceType;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Integer getRadius() {
        return this.radius;
    }

    public void setFenceBorder(String fenceBorder) {
        this.fenceBorder = fenceBorder;
    }

    public String getFenceBorder() {
        return this.fenceBorder;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaCode() {
        return this.areaCode;
    }
}
