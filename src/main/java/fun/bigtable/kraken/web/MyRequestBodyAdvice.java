package fun.bigtable.kraken.web;

import fun.bigtable.kraken.annotation.EncryptController;
import fun.bigtable.kraken.util.AESOperator;
import fun.bigtable.kraken.util.XssEscapeUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * RequestBody请求处理
 */
@Component
@ControllerAdvice(annotations = RestController.class)
public class MyRequestBodyAdvice implements RequestBodyAdvice {
    private final static Logger logger = LoggerFactory.getLogger(MyRequestBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {

        boolean encode = false;
        if (parameter.getMethod().isAnnotationPresent(EncryptController.class)) {
            //获取注解配置的包含和去除字段
            EncryptController encryptController = parameter.getMethodAnnotation(EncryptController.class);
            //是否加密
            encode = encryptController.req();
            if (encode) {
                return new MyHttpInputMessage(inputMessage, 1);
            }
        }
        return new MyHttpInputMessage(inputMessage, 0);

    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    class MyHttpInputMessage implements HttpInputMessage {
        private HttpHeaders headers;
        private InputStream body;

        public MyHttpInputMessage(HttpInputMessage inputMessage, int type) throws IOException {
            this.headers = inputMessage.getHeaders();
            String body = IOUtils.toString(inputMessage.getBody(), "UTF-8");
            if (type == 1) {
                try {
                    body = AESOperator.decrypt(body);
                    this.body = IOUtils.toInputStream(body, "UTF-8");
                } catch (Exception e) {
                    logger.error("解密失败：{}", body, e);
                    throw new IOException("解密失败");
                }
            }
            //XSS处理
            body = XssEscapeUtils.stripXSS(body);
            this.body = IOUtils.toInputStream(body, "UTF-8");

        }

        @Override
        public InputStream getBody() throws IOException {
            return body;
        }

        @Override
        public HttpHeaders getHeaders() {
            return headers;
        }
    }
}
