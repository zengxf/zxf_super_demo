package cn.zxf.web.test.common.service_exception;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceException() {
    }

    public ServiceException( String message ) {
        super( message );
    }

    public ServiceException( String message, Throwable cause ) {
        super( message, cause );
    }

}
