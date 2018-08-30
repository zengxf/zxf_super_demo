package cn.zxf.web.test.common.verify_exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class VerifyExceptionHandler {

    @ResponseStatus( HttpStatus.BAD_REQUEST )
    @ExceptionHandler( value = MethodArgumentNotValidException.class )
    public Map<String, Object> errorHandle( MethodArgumentNotValidException exception ) {
        StringBuilder sb = new StringBuilder();
        for ( ObjectError error : exception.getBindingResult()
                .getAllErrors() ) {
            sb.append( "[" )
                    .append( error.getDefaultMessage() )
                    .append( "] " );
        }

        Map<String, Object> json = new HashMap<>();
        json.put( "error", "表单校验失败" );
        json.put( "fieldError", sb.toString() );
        return json;
    }

}
