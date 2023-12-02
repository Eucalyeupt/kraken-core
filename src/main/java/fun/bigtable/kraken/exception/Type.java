package fun.bigtable.kraken.exception;


import org.apache.commons.lang3.StringUtils;

/**
 */
public enum Type {

    //自定义错误信息
    FAIL_INFO("999999", ""),
    // 参数异常
    PARAM_FAIL("400", ""),
    //正确返回
    SUCCESS("success", ""),
    //正确返回
    FAILED("failed", ""),
    // 系统错误
    SYSTEM_ERROR("01000", ""),
    //系统繁忙
    SYSTEM_BUSY("04000", ""),

    SYSTEM_ERROR_DECODE("01001", ""),

    ACCES_DENIED("01403", ""),
    SESSION_INVALID("01404", ""),
    NO_LOGIN("01405", ""),
    // 内部错误错误
    INTERNAL_ERROR("02000", ""),
    //积分事件未找到
    POINTEVENT_NOT_FOUND("02001", ""),
    //使用积分事件未定义
    USEPOINT_EVENT_NOT_DEFINED("02002", ""),
    //没有可用积分
    NO_POINT_USE("02003", ""),
    //积分不够用
    NOT_ENOUGH_POINT("02004", ""),
    //积分事件未找到
    GROWTH_LEVEL_ERROR("02002", ""),
    // 用户认证错误
    USER_AUTH("03000", ""),
    // 用户认证错误
    REQUEST_AUTH("03001", ""),
    //默认错误
    DEFAULT_ERROR("00000", ""),
    // 异常代码不存在
    NO_EXCEPTIONMSG("000002", ""),
    // 手机号不正确
    WRONG_PHONENO("000003", ""),
    //密码过期
    PASS_OUT_OF_TIME("0101020", ""),
    //账号或密码错误
    LOGIN_ERR("005009", ""),
    //账号或密码错误-次数超限，需要图片验证码
    LOGIN_ERR_UPTIME("005010", ""),
    // 模板编码为空
    TEMPLATECODE_NULL("000004", ""),
    // 非短信验证码
    WORONG_CODE("000005", ""),
    // 编码失败
    ENCODE_FAIL("000008", ""),
    // json转换异常
    JSONPROCESSINGEXCEPTION("000009", ""),
    NO_EXP("02005", ""),
    PARAM_ERROR("000006", ""),
    //xml解析异常
    XML_PARSE_FAIL("000010", ""),
    // 有关联数据，无法删除
    UNABLE_DELETE("000011", ""),
    // 模块重复
    DUPLICATE_MODULE("000012", ""),
    // 解析异常
    PARSE_EXCEPTION("000013", ""),

    ORDER_STATUS_ERROR("000007", ""),
    PARA_NULL("005001", ""),
    PHONEERR_NULL("005002", ""),
    PASSWORD_WRONG("005003", ""),
    NOTPIC("005004", ""),
    //重新登陆
    RELOGIN("005005", ""),

    // 支付
    // 账户不存在,请实名开通!
    ACC_NOT_EXIST("006001", ""),
    // 未匹配出银行，请手动选择!
    NO_MATCH_BANK("006002", ""),
    // 发送验证码失败
    SEND_CODE_FAIL("006003", ""),
    // 短信验证失败
    CODE_CHECK_FAIL("006004", ""),
    // 实名认证失败，请核实您填写的信息
    AUTH_REALINFO_FAIL("006005", ""),
    // 该信息已被他人认证过
    AUTH_REPEAT("006006", ""),
    // 请确认您的开户行及省份是否正确
    QUERY_LBANKNO_FAIL("006007", ""),
    // 输入的卡号无效
    AUTH_CARD_ERROR("006008", ""),
    // 您输入的卡号不支持实名
    AUTH_CARD_NO_SUPPORT("006009", ""),
    // 退款时订单不存在
    ORDER_NOT_EXIST("006010", ""),
    // 提交的信息有误
    PARAM_NOT_CORRECT("006011", ""),
    // 当前手机号不是您的预留手机号
    MOBILE_NOT_RESERVE("006012", ""),
    PAY_ACCOUNT_FORMAT_ERROR("006013", ""),
    PAY_ACCOUNT_BANKCARD_MORE("006014", ""),
    PAY_WITHDRAWAL_AMOUNT_LESS_0("006015", ""),
    PAY_WITHDRAWAL_BALANCE_LACK("006016", ""),
    PAY_WITHDRAWAL_CARD_WRONG("006017", ""),
    PAY_WITHDRAWAL_AUTHCODE_WRONG("006018", ""),
    PAY_WITHDRAWAL_STATE_ERROR("006019", ""),
    PAY_WITHDRAWAL_UNFREEZE_ERROR("006020", ""),
    PAY_WITHDRAWAL_BATCH_DEBIT_FAIL("006021", ""),
    PAY_ACCOUNT_CREATE_FAIL("006022", ""),
    PAY_ACCOUNT_CERT_FILE_EMPTY("006023", ""),
    PAY_ACCOUNT_CERT_EMPTY("006024", ""),
    PAY_ACCOUNT_CERT_APPROVE("006025", ""),
    PAY_ACCOUNT_CARD_EXIST("006026", ""),

    // http请求时异常处理
    // Socket连接出错
    SOCKETTIMEOUTEXCEPTION("007001", ""),
    // http连接出错
    HTTPEXCEPTION("007002", ""),
    // 不支持的编码异常
    UNSUPPORTEDENCODINGEXCEPTION("007003", ""),
    // IO流异常
    IOEXCEPTION("007004", ""),

    // 重复点击
    REPEAT_CLICK("007005", ""),

    USER_NOT_EXIST("0101001", ""),
    USER_DISABLE("0101002", ""),
    USER_PASSWORD_INVALIDATE("0101003", ""),
    USER_NAME_PASS_NULL("0101004", ""),
    USER_USER_ALREADY_EXIST("0101005", ""),
    USER_SEND_MESSAGE_ERROR("0101006", ""),
    USER_USER_EXIST("0101007", ""),
    USER_OLD_PASSWORD_WRONG("0101008", ""),
    USER_PASSWORD_SAME("0101009", ""),
    USER_AUTHCODE_WRONG("0101010", ""),
    USER_AUTH_FIRST("0101011", ""),
    USER_FILE_NULL("0101012", ""),
    USER_DUPLICATE("0101013", ""),
    USER_NO_AUTHORITY("0101014", ""),
    USER_LOGIN_OTHER_DEVICE("0101015", ""),
    PERM_NULL("0101016", ""),
    USER_CREDENTIAL_EXIST("0101017", ""),
    USER_CREDENTIAL_NOT_EXIST("0101018", ""),
    USER_CREDENTIAL_AUDIT_SUCCESS("0101019", ""),
    USER_VEHICLE_NULL("0104001", ""),
    USER_PLATENO_NULL("0104002", ""),
    USER_LOADHEIGHT_NULL("0104003", ""),
    USER_PLATELENGTH_NULL("0104004", ""),
    USER_VEHICLELICENSEPIC_NULL("0104005", ""),
    USER_TAXILICENSEPIC_NULL("0104006", ""),
    USER_VEHICLEFRONTPIC_NULL("0104007", ""),
    USER_VEHICLEBODYPIC_NULL("0104008", ""),

    PAY_BALANCE_LOGINNAME_NULL("0301001", ""),
    PAY_BALANCE_SEND_AUTHCODE_FAIL("0301002", ""),
    PAY_BALANCE_PHONE_EMPTY("0301003", ""),
    PAY_BALANCE_AUTH_FAIL("0301004", ""),
    PAY_BALANCE_SYSUSER_NULL("0301005", ""),
    PAY_BALANCE_AUTH("0301006", ""),
    PAY_BALANCE_FAIL("0301007", ""),
    PAY_RECON_FILE_DOWN_FAIL("0301008", ""),
    PAY_RECON_DZ_FILE_NOT_EXIST("0301009", ""),

    ORDER_REDPACKET_NULL("0302002", ""),
    ORDER_REDPACKET_INVALID("0302003", ""),
    ORDER_REDPACKET_PAYCONDITION("0302004", ""),

    //高速通行费
    QUERYTOLLTYPEFAIL("0304002", ""),
    QUERYBASERATEAIL("0304003", ""),
    MAPREQUESTFAIL("0304004", ""),
    OVERTIME("0304005", ""),

    ACTIVITY_OVER_PARTICIPATELIMIT("0308001", ""),
    ACTIVITY_ALREADY_PARTICIPATE("0308002", ""),
    ACTIVITY_ALREADY_ATTEND("0308003", ""),
    ACTIVITY_ALREADY_UNATTEND("0308004", ""),
    ACTIVITY_WINNING_NOT_MATCHING("0308005", ""),
    ACTIVITY_PARTICIPATE_NUMBER_FEW("0308006", ""),
    ACTIVITY_DRAW_UNDO("0308007", ""),
    ACTIVITY_SEND_DO("0308008", ""),
    ACTIVITY_DRAW_DO("0308009", ""),
    ACTIVITY_END("0308010", ""),

    VIOLATION_QUERY_FAIL("0307001", ""),
    VIOLATION_UPDATE_VEHICLE_FAIL("0307002", ""),
    VIOLATION_NETWORK_ERROR("0307003", ""),


    HIGHWAY_GET_MAP_ERROR("0304001", ""),
    ETC_OK("200", ""),
    COMMON_EXCEPTION_FILE_NOT_EXIST("0003001", ""),
    COMMON_EXCEPTION_UNKNOWMESSAGE("0003002", ""),
    COMMON_EXCEPTION_SYSTEMEXCEPTION("0003003", ""),
    COMMON_EXCEPTION_PARAM_COUNT_WRONG("0003004", ""),
    COMMON_EXCEPTION_REQUEST_WRONG("0003005", ""),
    COMMON_EXCEPTION_FILE_FAIL("0003006", ""),
    COMMON_SYSCONFIG_DUPLICATE("0004001", ""),
    COMMON_NOT_APK("0005001", ""),

    TIMETASK_EXCUTE_FAIL("0306001", ""),
    TIMETASK_PAUSE_FAIL("0306002", ""),
    TIMETASK_ADD_FAIL("0306003", ""),
    TIMETASK_DELETE_FAIL("0306004", ""),
    TIMETASK_RESUME_FAIL("0306005", ""),

    MIN_VERSION_AUTH("0401000", ""),
    VERSION_NULL("0401001", ""),

    THIRD_PLATFORM_AUTH_FAIL("0601001", ""),
    THIRD_PLATFORM_DISABLE("0601002", ""),
    THIRD_PLATFORM_CREATEKEY_FAIL("0601003", ""),
    GOODS_EXCHANGE_FAIL("0501001", ""),
    GOODS_STORE_SHORT("0501002", ""),

    CHECK_RECRULE_FAIL("0701001", ""),

    DES_ENCRYPT("0801001", ""),

    SUPPLEMENT_FAIL("0901001", ""),

    INCIDENT_EMPTY("1001001", ""),
    INCIDENT_FOCUSED("1001002", ""),
    GOODS_UP_MAX("0501003", ""),

    //车友帮
    //建帮个数超限
    GANG_GANG_CREATE_ABOVE("03110001", ""),
    //帮派已存在
    GANG_GANG_CREATE_EXIST("03110002", ""),
    //话题已存在
    GANG_TOPIC_CREATE_EXIST("03110003", ""),
    //不能创建话题
    GANG_TOPIC_CREATE_CANNOT("03110004", ""),
    //仅帮主可创建话题
    GANG_TOPIC_CREATE_ONLY_OWNER("03110005", ""),
    //帮派禁止创建话题
    GANG_TOPIC_CREATE_ALL_CANNOT("03110006", ""),


    //加油站 油价采集
    GASSTATION_CREATE_EXIST("03120001", ""),
    //参数错误
    ACARD_ARGS_ERR("03130000", ""),
    //A卡 提交失败
    ACARD_APPLY_FAILED("03130001", ""),
    //发卡 车辆信息不存在
    ACARD_SEND_NO_VEHICLE("03130002", ""),
    //绑卡失败
    ACARD_BANK_CARD_FAILED("03130003", ""),
    //账单不存在
    ACARD_REPAY_NOBILL("03130004", ""),
    //未绑卡
    ACARD_APPLY_NO_BAND("03130005", ""),
    //未查询到改用户提交初审的申请信息
    ACARD_NO_VALID_APPLY("03130006", ""),
    ACARD_NO_CARD("03130007", ""),
    ACARD_NOT_EXIST_USER("03130008", ""),
    ACARD_NOT_EXIST_CARD("03130009", ""),
    ACARD_REPAY_FAIL("03130010", ""),


    //加油卡
    ENTERPRISE_NOT_EXIST("0309001", ""),
    NORMAL_INVOICE_INVALID("0309002", ""),
    ENTERPRISE_INVOICE_INVALID("0309003", ""),


    FUEL_CARD_ENTERPRISE_APPLY_FAIL("0310001", ""),
    FUEL_CARD_USER_APPLY_FAIL("0310002", ""),
    FUEL_CARD_ENTERPRISE_NUM_ERROR("0310003", ""),
    FUEL_CARD_USER_APPLY_ERROR("0310004", ""),
    FUEL_CARD_USER_APPLY_REAPPLY("0310005", ""),
    FUEL_CARD_USER_UNAPPLY("0310006", ""),
    FUEL_CARD_USER_AUDIT_UNPASS("0310007", ""),
    FUEL_CARD_USER_RECEIVE_CONFIRM("0310008", ""),
    FUEL_CARD_ENTERPRISE_CREDENTIAL_CHANGE_APPLY("0310009", ""),
    FUEL_CARD_ENTERPRISE_CREDENTIAL_CHANGE_APPLY_ALREADY("0310010", ""),
    PAY_PASS_UPTIME("1200001", ""),//验密超时

    FULL_HANGBILL_LOCKFEE_STATION_ERROR("0502000", ""),

    FULL_HANGBILL_LOCKFEE_ERROR("0502001", ""),
    FULL_BILL_LOCKFEE_NOTENOUGTH_ERROR("0502003", ""),
    FULL_HANGBILL_LOCKFEE_ADJUST_ERROR("0502002", ""),

    PRODUCT_ONLY_VERIFY_PASS("0502004", ""),
    PRODUCT_NAME_HAS_EXIST("0502005", ""),

    FLEET_PICK_GRANT_FACE_FAIL("0502006", ""),

    // 数据重复
    DATA_DUPLICATE("1001003", ""),
    CARD_REPEAT("1101001", ""),

    //人脸验证
    WITH_DRAW_FACE_FAIL("0700100", ""),

    /**
     * 系统检测到您设置的密码过于简单，为了您的账号安全请重新设置新密码
     */
    WEAK_PASSWORD("0101021", ""),

    /**
     * "密码不能与登录手机号相同，请重新设置新密码"
     */
    USERNAME_PASSWORD_SAME("0101022", ""),

    PICK_CONFIRM("0700101", ""),
    PICK_FAIL("0700102", ""),
    DRIVER_CREATETIME_FAIL("0700103", ""),

    /**
     * 未开通优企贷（申请中）
     */
    YQD_LOAN_APPLY_CREDIT_ERROR("9990001", ""),
    /**
     * 借款产品-不支持录单运单支付
     */
    LOAN_APPLY_ERROR_IMPORT("9990002", ""),
    /**
     * 借款产品-不支持非司机本人收款运单支付
     */
    LOAN_APPLY_ERROR_ACCOUNT_USER("9990003", ""),
    /**
     * 借款产品-不支持先票后款
     */
    LOAN_APPLY_ERROR_PRIORITY_INVOICE("9990004", ""),
    /**
     * 运输监控服务-业务订金不足, 购买运单失败*
     */
    MONITOR_VIP_MONEY_ENOUGH("9990005", ""),
    /**
     * 三方油站下线标志码
     */
    OFFLINE_THIRD_STATION_CODE("9990006", ""),

    /**
     * 满易宝提现余额不足
     */
    MYB_WITHDRAWAL_ERROR("9990007", ""),

    ORG_RATE_ERROR("9990008", ""),

    OTHERS("-1", ""),

    ;

    private final String errorCode;

    private final String desc;



    Type(String errorCode, String desc) {
        this.errorCode = errorCode;
        this.desc = "";
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getDesc() {
        return "";
    }

    public static Type getByCode(String code) {
        for (Type value : Type.values()) {
            if (StringUtils.equals(code, value.errorCode)) {
                return value;
            }
        }
        return OTHERS;
    }
}
