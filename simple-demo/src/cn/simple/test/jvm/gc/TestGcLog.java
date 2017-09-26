package cn.simple.test.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * -Xms200m -Xmx200m -Xmn8m
 * -XX:+PrintGCDateStamps
 * -XX:+PrintGCTimeStamps -XX:+PrintGCDetails
 * -verbose:gc -Xloggc:C:\Users\Administrator\Desktop/gc.log
 * </pre>
 * 
 * <pre>
 * ����GC�������ߣ�http://gceasy.io
 * ���湤�ߣ����غ󹹽�����https://github.com/jewes/gchisto
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2017-09-20
 */
public class TestGcLog {
    public static void main( String[] args ) {
        while ( true ) {
            List<String> list = new ArrayList<>( 200 );
            System.out.println( list );
        }
    }
}
