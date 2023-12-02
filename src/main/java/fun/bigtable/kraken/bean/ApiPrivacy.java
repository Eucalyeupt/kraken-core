package fun.bigtable.kraken.bean;

import fun.bigtable.kraken.constant.YesNoEnum;

import java.util.Objects;

/**
 */
public class ApiPrivacy {
    /**
     * 主键
     */
    private Long id;
    /**
     * 主键
     */
    private String url;
    /**
     * 状态1开启 0.不开启
     * @see YesNoEnum
     */
    private Integer state;
    /**
     * 服务1.admin后台 2.tms
     */
    private Integer serviceType;
    /**
     * '隐私类型1.运单 2.货主
     */
    private Integer type;
    /**
     * '字段类型 1.手机号 2.身份证 3.从业资格证号 4.道路运输证 5.银行卡号 6.地址
     */
    private Integer fieldType;
    /**
     * 隐藏字段
     */
    private String privacyBody;
    /**
     * 替换字段
     */
    private String replaceBody;
    /**
     * 查询字段
     */
    private String queryBody;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String updateTime;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPrivacyBody() {
        return privacyBody;
    }

    public void setPrivacyBody(String privacyBody) {
        this.privacyBody = privacyBody;
    }


    public String getReplaceBody() {
        return replaceBody;
    }

    public void setReplaceBody(String replaceBody) {
        this.replaceBody = replaceBody;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
        this.fieldType = fieldType;
    }

    public String getQueryBody() {
        return queryBody;
    }

    public void setQueryBody(String queryBody) {
        this.queryBody = queryBody;
    }

    public enum ServiceType {

        ADMIN(1, "admin服务"),
        TMS(1, "tms服务"),
        ;


        private Integer code;
        private String desc;

        ServiceType(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public Integer getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

    }

    public enum Type {

        PERSON(1, "个人"),
        ORG(2, "企业"),
        VEHICLE(3, "车辆"),
        FULLCARBILL(4, "运单"),
        FULLWAYBILL(5, "订单"),
        CONTRACT(6, "合同"),
        CALLOUT(7, "外呼"),
        ADDRESS(8, "货主通讯录"),
        PAYERLIMIT(9, "收款人限额配置"),
        CUSTOMERREPORT(10, "客户报备"),
        SERVICEINFO(11, "加盟商"),
        PAYPLAN(12, "下游支付"),
        TRAILER(13, "挂车"),
        IDENTITYUSER(14, "司机审核"),
        IDENTITYVEHICLE(15, "车辆导入"),
        PAYTRANS(16, "支付流水"),
        ETCOPENCARD(17, "ETC开卡"),
        RELEARN(18, "继续教育"),
        CUSTOMERPLAN(19, "货物运输申报系统"),
        SYSORG(20, "满易企服货主"),
        CPPLTASK(21, "平台运力池任务中心"),
        FULLCARBILLCHECK(22, "运单审核配置"),
        USERACCOUNT(23, "账户绑定信息"),
        CUSTOMER(24, "客户标签统计"),
        CUSTOMERLOG(25, "标签情况统计"),
        ADMINUSER(26, "后台用户"),
        CPPLDRIVER(27, "平台运力池司机"),
        CPPLORG(28, "平台运力池渠道"),
        SYSUSER(29, "满易企服——商户管理"),
        ERROR(-1,"异常")
        ;


        private Integer code;
        private String desc;

        Type(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }


        public static Type getTypeByCode(int code){
            for (Type value : Type.values()) {
                if(Objects.equals(code,value.code)){
                    return value;
                }
            }
            return ERROR;
        }

        public Integer getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

    }

    public enum FieldType {

        PHONE(1, "手机号"),
        IDNUMBER(2, "身份证"),
        QUALIFICATIONNO(3, "从业资格证号"),
        TRANNO(4, "道路运输证"),
        BANKCARD(5, "银行卡号"),
        ADDRESS(6, "地址"),
        PHONEPHONESTRING(7, "包含手机号"),
        ERROR(-1,"异常")
        ;


        private Integer code;
        private String desc;

        FieldType(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }


        public static FieldType getFieldTypeByCode(int code){
            for (FieldType value : FieldType.values()) {
                if(Objects.equals(code,value.code)){
                    return value;
                }
            }
            return ERROR;
        }

        public Integer getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

    }
}
