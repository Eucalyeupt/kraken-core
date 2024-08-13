package fun.bigtable.kraken.exception;


import java.util.Objects;

/**
 *
 */
public enum Type {

    //自定义错误信息
    FAIL_INFO(999999, ""),
    // 参数异常
    PARAM_FAIL(400, ""),
    // 系统错误
    SYSTEM_ERROR(1000, ""),
    //系统繁忙
    SYSTEM_BUSY(4000, ""),

    SYSTEM_ERROR_DECODE(1001, ""),

    ACCES_DENIED(1403, ""),
    SESSION_INVALID(1404, ""),
    NO_LOGIN(1405, ""),
    // 内部错误错误
    INTERNAL_ERROR(2000, ""),
    //积分事件未找到
    POINTEVENT_NOT_FOUND(2001, ""),
    //使用积分事件未定义
    USEPOINT_EVENT_NOT_DEFINED(2002, ""),
    //没有可用积分
    NO_POINT_USE(2003, ""),
    //积分不够用
    NOT_ENOUGH_POINT(2004, ""),
    //积分事件未找到
    GROWTH_LEVEL_ERROR(2002, ""),
    // 用户认证错误
    USER_AUTH(3000, ""),
    // 用户认证错误
    REQUEST_AUTH(3001, ""),
    // 异常代码不存在
    NO_EXCEPTIONMSG(2, ""),
    // 手机号不正确
    WRONG_PHONENO(3, ""),
    //密码过期
    PASS_OUT_OF_TIME(101020, ""),
    //账号或密码错误
    LOGIN_ERR(5009, ""),
    //账号或密码错误-次数超限，需要图片验证码
    LOGIN_ERR_UPTIME(5010, ""),
    // 模板编码为空
    TEMPLATECODE_NULL(4, ""),
    // 非短信验证码
    WORONG_CODE(5, ""),
    // 编码失败
    ENCODE_FAIL(8, ""),
    // json转换异常
    JSONPROCESSINGEXCEPTION(9, ""),
    NO_EXP(2005, ""),
    PARAM_ERROR(6, ""),
    //xml解析异常
    XML_PARSE_FAIL(10, ""),
    // 有关联数据，无法删除
    UNABLE_DELETE(11, ""),
    // 模块重复
    DUPLICATE_MODULE(12, ""),
    // 解析异常
    PARSE_EXCEPTION(13, ""),

    ORDER_STATUS_ERROR(7, ""),
    PARA_NULL(5001, ""),
    PHONEERR_NULL(5002, ""),
    PASSWORD_WRONG(5003, ""),
    NOTPIC(5004, ""),
    //重新登陆
    RELOGIN(5005, ""),

    // 支付
    // 账户不存在,请实名开通!
    ACC_NOT_EXIST(6001, ""),
    // 未匹配出银行，请手动选择!
    NO_MATCH_BANK(6002, ""),
    // 发送验证码失败
    SEND_CODE_FAIL(6003, ""),
    // 短信验证失败
    CODE_CHECK_FAIL(6004, ""),
    // 实名认证失败，请核实您填写的信息
    AUTH_REALINFO_FAIL(6005, ""),
    // 该信息已被他人认证过
    AUTH_REPEAT(6006, ""),
    // 请确认您的开户行及省份是否正确
    QUERY_LBANKNO_FAIL(6007, ""),
    // 输入的卡号无效
    AUTH_CARD_ERROR(6008, ""),
    // 您输入的卡号不支持实名
    AUTH_CARD_NO_SUPPORT(6009, ""),
    // 退款时订单不存在
    ORDER_NOT_EXIST(6010, ""),
    // 提交的信息有误
    PARAM_NOT_CORRECT(6011, ""),
    // 当前手机号不是您的预留手机号
    MOBILE_NOT_RESERVE(6012, ""),
    PAY_ACCOUNT_FORMAT_ERROR(6013, ""),
    PAY_ACCOUNT_BANKCARD_MORE(6014, ""),
    PAY_WITHDRAWAL_AMOUNT_LESS_0(6015, ""),
    PAY_WITHDRAWAL_BALANCE_LACK(6016, ""),
    PAY_WITHDRAWAL_CARD_WRONG(6017, ""),
    PAY_WITHDRAWAL_AUTHCODE_WRONG(6018, ""),
    PAY_WITHDRAWAL_STATE_ERROR(6019, ""),
    PAY_WITHDRAWAL_UNFREEZE_ERROR(6020, ""),
    PAY_WITHDRAWAL_BATCH_DEBIT_FAIL(6021, ""),
    PAY_ACCOUNT_CREATE_FAIL(6022, ""),
    PAY_ACCOUNT_CERT_FILE_EMPTY(6023, ""),
    PAY_ACCOUNT_CERT_EMPTY(6024, ""),
    PAY_ACCOUNT_CERT_APPROVE(6025, ""),
    PAY_ACCOUNT_CARD_EXIST(6026, ""),

    // http请求时异常处理
    // Socket连接出错
    SOCKETTIMEOUTEXCEPTION(7001, ""),
    // http连接出错
    HTTPEXCEPTION(7002, ""),
    // 不支持的编码异常
    UNSUPPORTEDENCODINGEXCEPTION(7003, ""),
    // IO流异常
    IOEXCEPTION(7004, ""),

    // 重复点击
    REPEAT_CLICK(7005, ""),

    USER_NOT_EXIST(101001, ""),
    USER_DISABLE(101002, ""),
    USER_PASSWORD_INVALIDATE(101003, ""),
    USER_NAME_PASS_NULL(101004, ""),
    USER_USER_ALREADY_EXIST(101005, ""),
    USER_SEND_MESSAGE_ERROR(101006, ""),
    USER_USER_EXIST(101007, ""),
    USER_OLD_PASSWORD_WRONG(101008, ""),
    USER_PASSWORD_SAME(101009, ""),
    USER_AUTHCODE_WRONG(101010, ""),
    USER_AUTH_FIRST(101011, ""),
    USER_FILE_NULL(101012, ""),
    USER_DUPLICATE(101013, ""),
    USER_NO_AUTHORITY(101014, ""),
    USER_LOGIN_OTHER_DEVICE(101015, ""),
    PERM_NULL(101016, ""),
    USER_CREDENTIAL_EXIST(101017, ""),
    USER_CREDENTIAL_NOT_EXIST(101018, ""),
    USER_CREDENTIAL_AUDIT_SUCCESS(101019, ""),
    USER_VEHICLE_NULL(104001, ""),
    USER_PLATENO_NULL(104002, ""),
    USER_LOADHEIGHT_NULL(104003, ""),
    USER_PLATELENGTH_NULL(104004, ""),
    USER_VEHICLELICENSEPIC_NULL(104005, ""),
    USER_TAXILICENSEPIC_NULL(104006, ""),
    USER_VEHICLEFRONTPIC_NULL(104007, ""),
    USER_VEHICLEBODYPIC_NULL(104008, ""),

    PAY_BALANCE_LOGINNAME_NULL(301001, ""),
    PAY_BALANCE_SEND_AUTHCODE_FAIL(301002, ""),
    PAY_BALANCE_PHONE_EMPTY(301003, ""),
    PAY_BALANCE_AUTH_FAIL(301004, ""),
    PAY_BALANCE_SYSUSER_NULL(301005, ""),
    PAY_BALANCE_AUTH(301006, ""),
    PAY_BALANCE_FAIL(301007, ""),
    PAY_RECON_FILE_DOWN_FAIL(301008, ""),
    PAY_RECON_DZ_FILE_NOT_EXIST(301009, ""),

    ORDER_REDPACKET_NULL(302002, ""),
    ORDER_REDPACKET_INVALID(302003, ""),
    ORDER_REDPACKET_PAYCONDITION(302004, ""),

    //高速通行费
    QUERYTOLLTYPEFAIL(304002, ""),
    QUERYBASERATEAIL(304003, ""),
    MAPREQUESTFAIL(304004, ""),
    OVERTIME(304005, ""),

    ACTIVITY_OVER_PARTICIPATELIMIT(308001, ""),
    ACTIVITY_ALREADY_PARTICIPATE(308002, ""),
    ACTIVITY_ALREADY_ATTEND(308003, ""),
    ACTIVITY_ALREADY_UNATTEND(308004, ""),
    ACTIVITY_WINNING_NOT_MATCHING(308005, ""),
    ACTIVITY_PARTICIPATE_NUMBER_FEW(308006, ""),
    ACTIVITY_DRAW_UNDO(308007, ""),
    ACTIVITY_SEND_DO(308008, ""),
    ACTIVITY_DRAW_DO(308009, ""),
    ACTIVITY_END(308010, ""),

    VIOLATION_QUERY_FAIL(307001, ""),
    VIOLATION_UPDATE_VEHICLE_FAIL(307002, ""),
    VIOLATION_NETWORK_ERROR(307003, ""),


    HIGHWAY_GET_MAP_ERROR(304001, ""),
    ETC_OK(200, ""),
    COMMON_EXCEPTION_FILE_NOT_EXIST(3001, ""),
    COMMON_EXCEPTION_UNKNOWMESSAGE(3002, ""),
    COMMON_EXCEPTION_SYSTEMEXCEPTION(3003, ""),
    COMMON_EXCEPTION_PARAM_COUNT_WRONG(3004, ""),
    COMMON_EXCEPTION_REQUEST_WRONG(3005, ""),
    COMMON_EXCEPTION_FILE_FAIL(3006, ""),
    COMMON_SYSCONFIG_DUPLICATE(4001, ""),
    COMMON_NOT_APK(5001, ""),

    TIMETASK_EXCUTE_FAIL(306001, ""),
    TIMETASK_PAUSE_FAIL(306002, ""),
    TIMETASK_ADD_FAIL(306003, ""),
    TIMETASK_DELETE_FAIL(306004, ""),
    TIMETASK_RESUME_FAIL(306005, ""),

    MIN_VERSION_AUTH(401000, ""),
    VERSION_NULL(401001, ""),

    THIRD_PLATFORM_AUTH_FAIL(601001, ""),
    THIRD_PLATFORM_DISABLE(601002, ""),
    THIRD_PLATFORM_CREATEKEY_FAIL(601003, ""),
    GOODS_EXCHANGE_FAIL(501001, ""),
    GOODS_STORE_SHORT(501002, ""),

    CHECK_RECRULE_FAIL(701001, ""),

    DES_ENCRYPT(801001, ""),

    SUPPLEMENT_FAIL(901001, ""),

    INCIDENT_EMPTY(1001001, ""),
    INCIDENT_FOCUSED(1001002, ""),
    GOODS_UP_MAX(501003, ""),

    //车友帮
    //建帮个数超限
    GANG_GANG_CREATE_ABOVE(3110001, ""),
    //帮派已存在
    GANG_GANG_CREATE_EXIST(3110002, ""),
    //话题已存在
    GANG_TOPIC_CREATE_EXIST(3110003, ""),
    //不能创建话题
    GANG_TOPIC_CREATE_CANNOT(3110004, ""),
    //仅帮主可创建话题
    GANG_TOPIC_CREATE_ONLY_OWNER(3110005, ""),
    //帮派禁止创建话题
    GANG_TOPIC_CREATE_ALL_CANNOT(3110006, ""),


    //加油站 油价采集
    GASSTATION_CREATE_EXIST(3120001, ""),
    //参数错误
    ACARD_ARGS_ERR(3130000, ""),
    //A卡 提交失败
    ACARD_APPLY_FAILED(3130001, ""),
    //发卡 车辆信息不存在
    ACARD_SEND_NO_VEHICLE(3130002, ""),
    //绑卡失败
    ACARD_BANK_CARD_FAILED(3130003, ""),
    //账单不存在
    ACARD_REPAY_NOBILL(3130004, ""),
    //未绑卡
    ACARD_APPLY_NO_BAND(3130005, ""),
    //未查询到改用户提交初审的申请信息
    ACARD_NO_VALID_APPLY(3130006, ""),
    ACARD_NO_CARD(3130007, ""),
    ACARD_NOT_EXIST_USER(3130008, ""),
    ACARD_NOT_EXIST_CARD(3130009, ""),
    ACARD_REPAY_FAIL(3130010, ""),


    //加油卡
    ENTERPRISE_NOT_EXIST(309001, ""),
    NORMAL_INVOICE_INVALID(309002, ""),
    ENTERPRISE_INVOICE_INVALID(309003, ""),


    FUEL_CARD_ENTERPRISE_APPLY_FAIL(310001, ""),
    FUEL_CARD_USER_APPLY_FAIL(310002, ""),
    FUEL_CARD_ENTERPRISE_NUM_ERROR(310003, ""),
    FUEL_CARD_USER_APPLY_ERROR(310004, ""),
    FUEL_CARD_USER_APPLY_REAPPLY(310005, ""),
    FUEL_CARD_USER_UNAPPLY(310006, ""),
    FUEL_CARD_USER_AUDIT_UNPASS(310007, ""),
    FUEL_CARD_USER_RECEIVE_CONFIRM(310008, ""),
    FUEL_CARD_ENTERPRISE_CREDENTIAL_CHANGE_APPLY(310009, ""),
    FUEL_CARD_ENTERPRISE_CREDENTIAL_CHANGE_APPLY_ALREADY(310010, ""),
    PAY_PASS_UPTIME(1200001, ""),//验密超时

    FULL_HANGBILL_LOCKFEE_STATION_ERROR(502000, ""),

    FULL_HANGBILL_LOCKFEE_ERROR(502001, ""),
    FULL_BILL_LOCKFEE_NOTENOUGTH_ERROR(502003, ""),
    FULL_HANGBILL_LOCKFEE_ADJUST_ERROR(502002, ""),

    PRODUCT_ONLY_VERIFY_PASS(502004, ""),
    PRODUCT_NAME_HAS_EXIST(502005, ""),

    FLEET_PICK_GRANT_FACE_FAIL(502006, ""),

    // 数据重复
    DATA_DUPLICATE(1001003, ""),
    CARD_REPEAT(1101001, ""),

    //人脸验证
    WITH_DRAW_FACE_FAIL(700100, ""),

    /**
     * 系统检测到您设置的密码过于简单，为了您的账号安全请重新设置新密码
     */
    WEAK_PASSWORD(101021, ""),

    /**
     * "密码不能与登录手机号相同，请重新设置新密码"
     */
    USERNAME_PASSWORD_SAME(101022, ""),

    PICK_CONFIRM(700101, ""),
    PICK_FAIL(700102, ""),
    DRIVER_CREATETIME_FAIL(700103, ""),

    /**
     * 未开通优企贷（申请中）
     */
    YQD_LOAN_APPLY_CREDIT_ERROR(9990001, ""),
    /**
     * 借款产品-不支持录单运单支付
     */
    LOAN_APPLY_ERROR_IMPORT(9990002, ""),
    /**
     * 借款产品-不支持非司机本人收款运单支付
     */
    LOAN_APPLY_ERROR_ACCOUNT_USER(9990003, ""),
    /**
     * 借款产品-不支持先票后款
     */
    LOAN_APPLY_ERROR_PRIORITY_INVOICE(9990004, ""),
    /**
     * 运输监控服务-业务订金不足, 购买运单失败*
     */
    MONITOR_VIP_MONEY_ENOUGH(9990005, ""),
    /**
     * 三方油站下线标志码
     */
    OFFLINE_THIRD_STATION_CODE(9990006, ""),

    /**
     * 满易宝提现余额不足
     */
    MYB_WITHDRAWAL_ERROR(9990007, ""),

    ORG_RATE_ERROR(9990008, ""),

    OTHERS(-1, ""),

    ;

    private final Integer errorCode;

    private final String desc;


    Type(Integer errorCode, String desc) {
        this.errorCode = errorCode;
        this.desc = desc;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public String getDesc() {
        return desc;
    }

    public static Type getByCode(Integer code) {
        for (Type value : Type.values()) {
            if (Objects.equals(code, value.errorCode)) {
                return value;
            }
        }
        return OTHERS;
    }
}
