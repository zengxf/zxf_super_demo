package cn.simple.test.jvm.memory;

import java.lang.management.ManagementFactory;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * �������ò��ԣ�Survivor �� Eden �ı���
 * 
 * <pre>
 * -Xmx800m -Xms800m -XX:SurvivorRatio=2
 * 
 * SurvivorRatio=2 ��ʾ��S0:S1:Eden = 1:1:2 => Sall:Eden = 2:2
 * Ĭ��ֵΪ 8
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2017-09-21
 */
public class TestSurvivorRatio {
    public static void main( String[] args ) {
        System.out.println( ManagementFactory.getRuntimeMXBean().getName() );
        while ( true ) {
            IntStream.rangeClosed( 1, 200 ).boxed().collect( Collectors.toList() );
        }
    }
}
