package fun.bigtable.kraken.web;


import fun.bigtable.kraken.bean.Result;
import fun.bigtable.kraken.exception.Type;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@ResponseBody
public class ErrorPageAdvice {


    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<Boolean> result(){
        return Result.fail(Type.FAIL_INFO,"url not found");
    }

}
