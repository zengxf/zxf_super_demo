package cn.zxf.web.test.common.auth_exception;

public class AuthException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AuthException( String message ) {
        super( message );
    }

}
