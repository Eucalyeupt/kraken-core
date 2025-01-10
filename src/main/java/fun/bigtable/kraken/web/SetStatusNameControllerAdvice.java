package fun.bigtable.kraken.web;

import fun.bigtable.kraken.bean.Result;
import fun.bigtable.kraken.page.result.PageInfo;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;
import java.util.Objects;

@RestControllerAdvice
public class SetStatusNameControllerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return Result.class.isAssignableFrom(returnType.getParameterType()) ||
                PageInfo.class.isAssignableFrom(returnType.getParameterType()) ||
                List.class.isAssignableFrom(returnType.getParameterType()) ||
                SetStatusName.class.isAssignableFrom(returnType.getParameterType());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if (body instanceof Result<?>) {
            Object responseBeanBody = ((Result<?>) body).getBody();
            dealBody(responseBeanBody);
        } else {
            dealBody(body);
        }
        return body;
    }

    private void dealBody(Object responseBeanBody){

        if(Objects.isNull(responseBeanBody)){
            return;
        }

        if (responseBeanBody instanceof PageInfo) {
            List list = ((PageInfo) responseBeanBody).getList();

            if(Objects.isNull(list)){
                return;
            }

            for (Object o : list) {
                if (o instanceof SetStatusName) {
                    ((SetStatusName) o).setName();
                }
            }
        } else if (responseBeanBody instanceof List) {
            for (Object o : (List) responseBeanBody) {
                if (o instanceof SetStatusName) {
                    ((SetStatusName) o).setName();
                }
            }
        } else if (responseBeanBody instanceof SetStatusName) {
            ((SetStatusName) responseBeanBody).setName();
        }
    }
}
