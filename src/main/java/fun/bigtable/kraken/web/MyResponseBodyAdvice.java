package fun.bigtable.kraken.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import fun.bigtable.kraken.annotation.EncryptController;
import fun.bigtable.kraken.util.AESOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回数据加密
 */
@Component
@ControllerAdvice(annotations = ResponseBody.class)
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    private final static Logger log = LoggerFactory.getLogger(MyResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        boolean encode = false;
        if (returnType.getMethod().isAnnotationPresent(EncryptController.class)) {
            //获取注解配置的包含和去除字段
            EncryptController encryptController = returnType.getMethodAnnotation(EncryptController.class);
            //是否加密
            encode = encryptController.res();
        }
        if (encode) {
            log.info("对方法method :" + returnType.getMethod().getName() + "返回数据进行加密");
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
                return AESOperator.encrypt(result).replace("\r", "").replace("\n", "").replace("\"", "");
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        return body;
    }
}
