package fun.bigtable.kraken.web.advice;

import fun.bigtable.kraken.web.anno.IdlerController;
import fun.bigtable.kraken.web.wrapper.AbsIdlerBodyWrapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 懒狗controller通知
 */
@RestControllerAdvice(annotations = IdlerController.class)
public class IdlerControllerAdvice implements ResponseBodyAdvice<Object> {

    AbsIdlerBodyWrapper bodyGenerate;

    public IdlerControllerAdvice(AbsIdlerBodyWrapper bodyGenerate) {
        this.bodyGenerate = bodyGenerate;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return bodyGenerate.gen(body);
    }
}
