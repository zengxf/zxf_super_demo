package cn.simple.test.jvm.gc.log;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ��� TenuringThreshold ����ֵ <br>
 * <br>
 * 
 * ����
 * 
 * <pre>
 * -Xms200m -Xmx200m -Xmn8m
 * -XX:+PrintTenuringDistribution
 * </pre>
 * 
 * ���ʾ��
 * 
 * <pre>
 * Desired survivor size 2621440 bytes, new threshold 1 (max 15)
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2017-09-20
 */
public class TestPrintTenuringDistribution {
    public static void main( String[] args ) {
        int k = 1024;
        while ( true ) {
            int r = 1 + new Random().nextInt( 5 );
            System.out.println( "r: " + r + " mb" );
            System.gc();
            IntStream.rangeClosed( 1, r * k * k ).boxed().collect( Collectors.toList() );
        }
    }
}
