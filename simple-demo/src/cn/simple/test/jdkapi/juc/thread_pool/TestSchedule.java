package cn.simple.test.jdkapi.juc.thread_pool;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.simple.util.SleepUtils;

import static java.util.concurrent.Executors.*;

/**
 * 如果没有处理好异常，则当前的任务以后是不会执行的 <br>
 * FixedRate() 从任务开始计时 <br>
 * FixedDelay() 从任务结束后才计时 <br>
 * 
 * <p>
 * Created by zengxf on 2018-03-06
 */
public class TestSchedule {

    public static void main( String[] args ) {
        testFixedRate();
    }

    static void testFixedRate() {
        ScheduledExecutorService pool = newScheduledThreadPool( 4 );
        Runnable r = () -> {
            System.out.println( "--------" );
            SleepUtils.second( 2 );
            System.out.printf( "--- ok --- %tT %n", System.currentTimeMillis() );
        };
        System.out.printf( "--- start --- %tT %n", System.currentTimeMillis() );
        pool.scheduleAtFixedRate( r, 1000, 1000, TimeUnit.MILLISECONDS );
    }

    static void testFixedDelay() {
        ScheduledExecutorService pool = newScheduledThreadPool( 4 );
        Runnable r = () -> {
            System.out.println( "--------" );
            SleepUtils.second( 2 );
            System.out.printf( "--- ok --- %tT %n", System.currentTimeMillis() );
        };
        System.out.printf( "--- start --- %tT %n", System.currentTimeMillis() );
        pool.scheduleWithFixedDelay( r, 1000, 1000, TimeUnit.MILLISECONDS );
    }

    static void testError() {
        ScheduledExecutorService pool = newScheduledThreadPool( 4 );
        Runnable r = () -> {
            System.out.println( "--------" );
            if ( System.currentTimeMillis() % 2 == 0 ) {
                System.out.println( "--- error" );
                System.out.println( 1 / 0 );
            } else {
                System.out.println( "--- ok" );
            }
        };
        pool.scheduleAtFixedRate( r, 1000, 1000, TimeUnit.MILLISECONDS );
    }

}
