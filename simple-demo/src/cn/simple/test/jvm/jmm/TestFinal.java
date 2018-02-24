package cn.simple.test.jvm.jmm;

import java.util.stream.IntStream;

import cn.simple.util.SleepUtils;
import lombok.Data;

/**
 * 测试 final 域会不会未正确初始化
 * 
 * <p>
 * Created by zengxf on 2018-02-24
 */
public class TestFinal {

    public static void main( String[] args ) throws Exception {
        Runnable r = () -> {
            new TestFinalInner();
        };

        Runnable r1 = () -> {
            TestFinalInner a = TestFinalInner.instance;
            System.out.println( Thread.currentThread().getName() + " ----> " + a );
        };

        IntStream.range( 1, 10 ).forEach( i -> {
            new Thread( r1, "test-" + i ).start();
        } );

        new Thread( r, "test-init" ).start();

        IntStream.range( 1, 3 ).forEach( i -> {
            System.out.println( "==== main ----> " + new TestFinalInner() );
        } );
    }

    @Data
    static class TestFinalInner {
        final int             final_i;
        int                   common_i;
        int[]                 arr;
        static TestFinalInner instance;

        TestFinalInner() {
            instance = this;
            SleepUtils.second( 1 ); // 模拟长时操作
            final_i = 1;
            common_i = 1;
            arr = IntStream.range( 1, 10 ).toArray();
        }
    }

}
