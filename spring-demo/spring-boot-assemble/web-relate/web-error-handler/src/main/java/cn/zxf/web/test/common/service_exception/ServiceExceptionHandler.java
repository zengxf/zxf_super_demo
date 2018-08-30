package cn.zxf.web.test.common.service_exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler( value = ServiceException.class )
    public Result errorHandle( ServiceException exception ) {
        String errorMessage = exception.getMessage();
        return new Result().setCode( 400 )
                .setMessage( errorMessage );
    }

}
