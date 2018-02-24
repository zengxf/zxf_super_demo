package cn.simple.test.thread.common_op;

import cn.simple.util.SleepUtils;

/**
 * suspend() 不会释放锁
 * 
 * <p>
 * Created by zengxf on 2018-02-23
 */
public class TestThreadSuspeed {

    static Object lock = new Object();

    @SuppressWarnings( "deprecation" )
    public static void main( String[] args ) {

        Runnable r1 = () -> {
            synchronized ( lock ) {
                System.out.println( Thread.currentThread().getName() + " ----------- 1" );
                SleepUtils.second( 1 );
                System.out.println( Thread.currentThread().getName() + " ----------- 2" );
                SleepUtils.second( 1 );
                System.out.println( Thread.currentThread().getName() + " ----------- 3" );
                SleepUtils.second( 1 );
                System.out.println( Thread.currentThread().getName() + " ----------- 4" );
            }
        };

        Thread t1 = new Thread( r1, "test-01" );
        t1.start();
        Thread t2 = new Thread( r1, "test-02" );
        t2.start();

        SleepUtils.second( 1 );
        System.out.println( "================= 0" );
        t2.suspend();
        System.out.println( "================= 1" );

        SleepUtils.second( 1 );
        System.out.println( "================= 2" );
        t2.resume();
        System.out.println( "================= 3" );
    }

}
