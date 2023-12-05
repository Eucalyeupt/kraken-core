package fun.bigtable.kraken.exception;

import fun.bigtable.kraken.bean.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public Result<Object> defaultExceptionHandler(BusinessException e) {
        log.error(e.getMessage(), e);

        return Result.fail(e.getErrorType(), e.getMessage());
    }
}
