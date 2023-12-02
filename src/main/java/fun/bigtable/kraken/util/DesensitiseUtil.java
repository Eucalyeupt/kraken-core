package fun.bigtable.kraken.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 脱敏工具类
 *
 */
public class DesensitiseUtil {

    public static String DEFAULT_REPLACEMENT = "*";

    private static final Logger logger = LoggerFactory.getLogger(DesensitiseUtil.class);

    /**
     * 手机号脱敏
     *
     * @param mobile 明文手机号
     * @return 脱敏结果，保留前3位后4位
     */
    public static String desensitizeMobile(String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return mobile;
        }
        if(mobile.length() < 7){
            return mobile;
        }
        int end = mobile.length() - 4;
        return maskBetween(mobile, 3, end, null);
    }

    /**
     * 手机号list脱敏
     *
     * @param mobiles 明文手机号
     * @return 脱敏结果，保留前3位后4位
     */
    public static List<String> desensitizeMobileList(List<String>  mobiles) {
        if (CollectionUtils.isEmpty(mobiles)) {
            return mobiles;
        }
        List<String> newResults = new ArrayList<>();
        for (String mobile : mobiles) {
            String newMobile = desensitizeMobile(mobile);
            newResults.add(newMobile);
        }
        return newResults;
    }

    /**
     * 识别手机号加密
     *
     * @param mobile 明文手机号
     * @return 脱敏结果，保留前3位后4位
     */
    public static String desensitizeMobileString(String mobile) {

        if (StringUtils.isBlank(mobile)) {
            return mobile;
        }
        try {
            String phoneRegex = "1\\d{10}";
            Pattern phonePattern = Pattern.compile(phoneRegex);
            Matcher phoneMatcher = phonePattern.matcher(mobile);
            if (phoneMatcher.find()) {
                String phoneNumber = phoneMatcher.group();
                String newPhoneNumber = DesensitiseUtil.desensitizeMobile(phoneNumber);
                Matcher matcher = phonePattern.matcher(mobile);
                return matcher.replaceAll(newPhoneNumber);
            }
        }catch (Exception e){
            logger.error("加密失败--", e);
        }
        return mobile;

    }


    /**
     * 固定电话脱敏,保留前4位
     *
     * @param tel 明文固话
     * @return 脱敏结果，保留前4位
     */
    public static String desensitizeTel(String tel) {
        return maskRetainLeft(tel, 4, null);
    }

    /**
     * 脱敏电子邮箱，保留前2位 @后面的
     *
     * @param email 电子邮箱
     * @return 脱敏结果，保留前2位 @后面的
     */
    public static String desensitizeEmail(String email) {
        if (StringUtils.isBlank(email) || StringUtils.indexOf(email, "@") < 3) {
            return email;
        }
        int end = email.indexOf("@");
        return maskBetween(email, 2, end, null);
    }

    /**
     * 脱敏详细地址，保留前2位 后2位
     *
     * @param detailAddress 详细地址
     * @return 脱敏结果，保留前2位 后2位
     */
    public static String desensitizeDetailAddress(String detailAddress) {
        if (StringUtils.isBlank(detailAddress) || detailAddress.length() < 5) {
            return detailAddress;
        }
        int end = detailAddress.length() - 2;
        return maskBetween(detailAddress, 2, end, null);
    }

    /**
     * 身份证脱敏，保留前7位及倒数第2位
     *
     * @param idcard 明文身份证号
     * @return 脱敏结果，保留前7位及倒数第2位
     */
    public static String desensitizeIdCard(String idcard) {
        if (StringUtils.isBlank(idcard)) {
            return idcard;
        }
        int end = idcard.length() - 2;
        return maskBetween(idcard, 7, end, null);
    }

    /**
     * 身份证脱敏，保留前10位及倒数第4位
     *
     * @param idcard 明文身份证号
     * @return 脱敏结果，保留前10位及倒数第4位
     */
    public static String desensitizeIdCard4(String idcard) {
        if (StringUtils.isBlank(idcard)) {
            return idcard;
        }
        if(idcard.length() < 15){
            return idcard;
        }
        int end = idcard.length() - 4;
        return maskBetween(idcard, 10, end, null);
    }

    /**
     * 姓名脱敏
     *
     * @param name 姓名
     * @return 脱敏结果，保留前1位后1位
     */
    public static String desensitizeUserName(String name) {
        if (StringUtils.isBlank(name)) {
            return name;
        }
        if(name.length() <= 2){
            return maskRight(name, 1, null);
        }
        int end = name.length() - 1;
        return maskBetween(name, 1, end, null);
    }

    /**
     * 脱敏公司名称，保留前2位后2位
     *
     * @param companyName 公司名称
     * @return 脱敏结果，保留前2位后2位
     */
    public static String desensitizeCompany(String companyName) {
        if (StringUtils.isBlank(companyName)) {
            return companyName;
        }
        int sub = 2;
        if(companyName.length() <= 6){
            sub = 1;
        }
        int end = companyName.length() - sub;
        if (end<sub){
            end = sub;
        }
        return maskBetween(companyName, sub, end, null);
    }


    /**
     * 道路运输证脱敏，保留前4位和后4位,身份证号、从业资格证号，保留前4位后4位，中间10位加星
     *
     * @param idcard 明文身份证号
     * @return 脱敏结果，保留前7位及倒数第2位
     */
    public static String desensitizeRoadTransportPermit(String idcard) {
        if (StringUtils.isBlank(idcard)) {
            return idcard;
        }
        int end = idcard.length() - 4;
        if (end < 4){
            return idcard;
        }
        return maskBetween(idcard, 4, end, null);
    }

    /**
     * 银行卡号脱敏，保留前3位和后4位
     *
     * @param idcard 明文身份证号
     * @return 脱敏结果，保留前7位及倒数第2位
     */
    public static String desensitizeBankCardNo(String idcard) {
        if (StringUtils.isBlank(idcard)) {
            return idcard;
        }
        int end = idcard.length() - 4;
        return maskBetween(idcard, 3, end, null);
    }

    /**
     * 脱敏地址保留前10个字，10个字以内的保留前3个字
     *
     * @param detailAddress 详细地址
     * @return 脱敏结果，保留前2位 后2位
     */
    public static String desensitizeAddress(String detailAddress) {
        if (StringUtils.isBlank(detailAddress)) {
            return detailAddress;
        }
        if (detailAddress.length() <= 10){
            return maskRetainLeft(detailAddress, 3, null);
        }
        return maskRetainLeft(detailAddress, 10, null);
    }

    /**
     * 将字符串开始位置到结束位置之间的字符用指定字符替换
     *
     * @param sourceStr   待处理字符串
     * @param begin       开始替换位置(索引0开始)
     * @param end         结束替换位置(当前位置不替换)
     * @param replacement 替换字符,默认*
     * @return 脱敏结果
     */
    public static String maskBetween(String sourceStr, int begin, int end, String replacement) {
        if (StringUtils.isBlank(sourceStr)) {
            return sourceStr;
        }
        if (begin > end) {
            throw new RuntimeException("脱敏开始位置不能小于结束位置");
        }
        int length = sourceStr.length();
        if (begin > length) {
            throw new RuntimeException("脱敏开始位置不能大于字段长度");
        }
        if (length <= end) {
            return sourceStr;
        }
        int rightLength = length - end;
        replacement = StringUtils.isBlank(replacement) ? DEFAULT_REPLACEMENT : replacement;
        String removeStr = "";
        for (int i = 0; i < begin; i++) {
            removeStr = StringUtils.join(removeStr, replacement);
        }
        return StringUtils.left(sourceStr, begin)
                .concat(
                        StringUtils.removeStart(
                                StringUtils.leftPad(StringUtils.right(sourceStr, rightLength), StringUtils.length(sourceStr), replacement),
                                removeStr));
    }


    /**
     * 保留前N位字符
     *
     * @param sourceStr   待处理字符串
     * @param begin       开始替换位置
     * @param replacement 替换字符,默认*
     * @return
     */
    public static String maskRetainLeft(String sourceStr, int begin, String replacement) {
        if (StringUtils.isBlank(sourceStr)) {
            return sourceStr;
        }
        int length = sourceStr.length();
        if (begin > length) {
            return sourceStr;
        }
        replacement = StringUtils.isBlank(replacement) ? DEFAULT_REPLACEMENT : replacement;
        return StringUtils.rightPad(StringUtils.left(sourceStr, begin), StringUtils.length(sourceStr), replacement);
    }

    /**
     * 保留后N位字符
     *
     * @param sourceStr   待处理字符串
     * @param end         脱敏结束位置
     * @param replacement 替换字符,默认*
     * @return
     */
    public static String maskRetainRight(String sourceStr, int end, String replacement) {
        if (StringUtils.isBlank(sourceStr)) {
            return sourceStr;
        }
        int length = sourceStr.length();
        if (end <= 0 || end > length) {
            return sourceStr;
        }
        replacement = StringUtils.isBlank(replacement) ? DEFAULT_REPLACEMENT : replacement;
        return StringUtils.leftPad(StringUtils.right(sourceStr, end), length, replacement);
    }

    /**
     * 脱敏后N位字符
     *
     * @param sourceStr     待处理字符串
     * @param sensitiveSize 脱敏长度
     * @param replacement   替换字符,默认*
     * @return
     */
    public static String maskRight(String sourceStr, int sensitiveSize, String replacement) {
        if (StringUtils.isBlank(sourceStr)) {
            return sourceStr;
        }
        if (sensitiveSize <= 0) {
            return sourceStr;
        }
        int length = sourceStr.length();
        replacement = StringUtils.isBlank(replacement) ? DEFAULT_REPLACEMENT : replacement;
        return StringUtils.rightPad(StringUtils.left(sourceStr, length - sensitiveSize), length, replacement);
    }

    /**
     * 脱敏前N位字符
     *
     * @param sourceStr     待处理字符串
     * @param sensitiveSize 脱敏长度
     * @param replacement   替换字符,默认*
     * @return
     */
    public static String maskLeft(String sourceStr, int sensitiveSize, String replacement) {
        if (StringUtils.isBlank(sourceStr)) {
            return sourceStr;
        }
        if (sensitiveSize <= 0) {
            return sourceStr;
        }
        int length = sourceStr.length();
        int end = length - sensitiveSize;
        replacement = StringUtils.isBlank(replacement) ? DEFAULT_REPLACEMENT : replacement;
        return StringUtils.leftPad(StringUtils.right(sourceStr, end), length, replacement);
    }

}
