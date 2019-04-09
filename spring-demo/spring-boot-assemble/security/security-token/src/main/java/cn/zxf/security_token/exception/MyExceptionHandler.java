package cn.zxf.security_token.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler( NoAuthException.class )
    @ResponseStatus( HttpStatus.UNAUTHORIZED )
    public Map<String, Object> processNoAuthException( NoAuthException e ) {
        log.warn( "认证异常！user-id: {}, type: {}", e.userId, e.type );
        Map<String, Object> json = new HashMap<>();
        return json;
    }

}
