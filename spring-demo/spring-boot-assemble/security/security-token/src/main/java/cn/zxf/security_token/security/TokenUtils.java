package cn.zxf.security_token.security;

public class TokenUtils {
    
    private static long INTERVAL = 60L * 60 * 1000;

    public static String generate( Integer userId ) {
        String token = String.format( "ok:%d:%d", userId, System.currentTimeMillis() );
        return SecretUtils.encrypt( token );
    }

    public static Integer parse( String token ) {
        String str = SecretUtils.decrypt( token );
        if ( str.isEmpty() )
            return null;
        String[] arr = str.split( ":" );
        if ( arr.length != 3 )
            return null;
        String time = arr[2];
        long ctime = Long.parseLong( time );
        if ( ctime + INTERVAL < System.currentTimeMillis() )
            return null;
        String uid = arr[1];
        return Integer.valueOf( uid );
    }

}
