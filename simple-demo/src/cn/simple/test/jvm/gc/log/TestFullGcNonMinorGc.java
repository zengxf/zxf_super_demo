package cn.simple.test.jvm.gc.log;

/**
 * 
 * ��֤ FullGC û�е��� MinorGC <br>
 * <br>
 * 
 * ����
 * 
 * <pre>
 * -verbose:gc
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2017-09-29
 */
public class TestFullGcNonMinorGc {
    public static void main( String[] args ) {
        System.gc();
        System.out.println( "ok" );
    }
}
