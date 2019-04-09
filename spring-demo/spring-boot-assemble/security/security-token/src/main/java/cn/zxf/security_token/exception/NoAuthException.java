package cn.zxf.security_token.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NoAuthException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public final Integer      userId;
    public final Type         type;

    public static NoAuthException ofByNull() {
        return new NoAuthException( null, Type.NULL );
    }

    public static NoAuthException ofByInvalid( Integer userId ) {
        return new NoAuthException( userId, Type.INVALID );
    }

    public static NoAuthException ofByHacker( Integer userId ) {
        return new NoAuthException( userId, Type.HACKER );
    }

    // -------

    public static enum Type {
        NULL, INVALID, HACKER
    }

}
