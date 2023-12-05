package fun.bigtable.kraken.web;

import fun.bigtable.kraken.annotation.ApiDeprecated;
import fun.bigtable.kraken.exception.BusinessException;
import fun.bigtable.kraken.exception.Type;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Optional;

/**
 * 使用切面重构
 */
@RestControllerAdvice
public class ApiDeprecatedAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return Optional.ofNullable(methodParameter.getMethod())
                .map(method -> method.isAnnotationPresent(ApiDeprecated.class))
                .orElse(false);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ApiDeprecated annotation = methodParameter.getMethod().getAnnotation(ApiDeprecated.class);
        String msg = annotation.msg();
        if (StringUtils.isEmpty(msg)) {
            msg = "该功能已暂停使用，请退出重新登录，或联系运营人员";
        }
        throw new BusinessException(Type.FAIL_INFO, msg);
    }
}
