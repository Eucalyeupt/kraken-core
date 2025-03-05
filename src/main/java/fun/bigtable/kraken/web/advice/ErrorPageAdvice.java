package fun.bigtable.kraken.web.advice;


import fun.bigtable.kraken.bean.Result;
import fun.bigtable.kraken.exception.Type;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 错误页处理
 */
@RestControllerAdvice
@ResponseBody
public class ErrorPageAdvice {

    /**
     * 404错误
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<Boolean> result() {
        return Result.fail(Type.FAIL_INFO, "url not found");
    }

}
