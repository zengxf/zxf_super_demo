package cn.zxf.web.test.common.auth_exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler( value = AuthException.class )
    public ResponseEntity<Map<String, Object>> errorHandle( AuthException exception ) {
        String errorMessage = exception.getMessage();
        Map<String, Object> json = new HashMap<>();
        json.put( "error", "权限认证异常" );
        json.put( "message", errorMessage );
        return new ResponseEntity<>( json, HttpStatus.UNAUTHORIZED );
    }

}
