package fun.bigtable.kraken.web;

import fun.bigtable.kraken.annotation.EncryptMethod;
import fun.bigtable.kraken.bean.Result;
import fun.bigtable.kraken.constant.SensitiveTypeEnum;
import fun.bigtable.kraken.page.result.PageInfo;
import fun.bigtable.kraken.util.DesensitiseUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Field;
import java.util.*;

@ControllerAdvice
public class EncryptResponseAdvice implements ResponseBodyAdvice {

    private static final Logger log = LoggerFactory.getLogger(EncryptResponseAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return Objects.nonNull(returnType.getMethod().getDeclaredAnnotation(EncryptMethod.class));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        try {
            handleEncrypt(body, returnType.getMethodAnnotation(EncryptMethod.class));
        } catch (Exception e) {
            log.error("脱敏异常" + e.getMessage(), e);
        }

        return body;
    }


    /**
     * 处理加密
     *
     * @param responseObj 返回对象
     */
    private void handleEncrypt(Object responseObj, EncryptMethod method) throws IllegalAccessException {

        Set<String> encryptFieldSet = new HashSet<>(Arrays.asList(method.field()));

        if (Objects.isNull(responseObj)) {
            return;
        }

        SensitiveTypeEnum type = method.type();

        if (responseObj instanceof Result) {

            Result result = (Result) responseObj;
            Object body = result.getBody();
            dealWithBusinessBody(body, encryptFieldSet,type);

        }
         else if (responseObj instanceof List) {
            dealWithBusinessBody(responseObj, encryptFieldSet,type);
        }
    }

    private void dealWithBusinessBody(Object body, Set<String> encryptFieldSet,SensitiveTypeEnum type) throws IllegalAccessException {

        if(Objects.isNull(body)){
            return;
        }

        if (body instanceof PageInfo) {
            PageInfo pageInfo = (PageInfo) body;
            for (Object o : pageInfo.getList()) {
                encryptObject(o, encryptFieldSet,type);
            }
        } else if (body instanceof List) {
            List pageInfo = (List) body;
            for (Object o : pageInfo) {
                encryptObject(o, encryptFieldSet,type);
            }
        } else if (body instanceof Map) {
            Map bodyMap = (Map) body;
            if (bodyMap.containsKey("list") && CollectionUtils.isNotEmpty((List) bodyMap.get("list"))) {
                for (Object o : (List) bodyMap.get("list")) {
                    encryptObject(o, encryptFieldSet,type);
                }
            }

        } else {
            encryptObject(body, encryptFieldSet,type);
        }
    }

    private void encryptObject(Object object, Set<String> encryptFieldSet, SensitiveTypeEnum type) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();

        if (object instanceof Map) {
            Map objectMap = (Map) object;

            for (String encryptField : encryptFieldSet) {

                if (objectMap.containsKey(encryptField)) {
                    objectMap.put(encryptField, getEncryptResult((String) objectMap.get(encryptField), type));
                }
            }
        } else {
            for (Field field : fields) {

                boolean hasSecureField = encryptFieldSet.contains(field.getName());
                if (hasSecureField) {
                    field.setAccessible(true);
                    String plaintextValue = (String) field.get(object);
                    if (StringUtils.isEmpty(plaintextValue)) {
                        continue;
                    }
                    String encryptValue = getEncryptResult(plaintextValue,type);
                    field.set(object, encryptValue);
                }
            }
        }
    }

    private String getEncryptResult(String value, SensitiveTypeEnum type) {
        if(StringUtils.isBlank(value)){
            return value;
        }

        switch (type){
            case MOBILE_PHONE:
                return DesensitiseUtil.desensitizeMobile(value);
            case EMAIL:
                return DesensitiseUtil.desensitizeEmail(value);
            default:
                return DesensitiseUtil.maskLeft(value, value.length(), null);
        }

    }

}
