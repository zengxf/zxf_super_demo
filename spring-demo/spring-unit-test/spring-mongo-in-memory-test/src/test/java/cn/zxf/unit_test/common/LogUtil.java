package cn.zxf.unit_test.common;

public abstract class LogUtil {

    public static void info( String format, Object... arguments ) {
	System.out.println();
	System.out.println();
	System.out.println( String.format( format.replace( "{}", "%s" ), arguments ) );
	System.out.println();
	System.out.println();
    }

}
