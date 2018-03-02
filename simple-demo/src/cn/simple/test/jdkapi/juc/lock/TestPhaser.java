package cn.simple.test.jdkapi.juc.lock;

import java.util.concurrent.Phaser;
import java.util.stream.IntStream;

import cn.simple.util.SleepUtils;

/**
 * 1) 类似 CyclicBarrier，等待所有的线程到达再执行 <br>
 * 2) 类似 CountDownLatch，countDown() 与 await()
 * 
 * <p>
 * Created by zengxf on 2018-02-27
 */
public class TestPhaser {

    public static void main( String[] args ) {
        test1();
    }

    // 等待所有的线程到达再执行
    static void test1() {
        int count = 3;
        Phaser p = new Phaser( count );
        Runnable r = () -> {
            SleepUtils.second( 1 );
            System.out.println( Thread.currentThread().getName() + " in ..." );
            p.arriveAndAwaitAdvance();
            SleepUtils.second( 1 );
            System.out.println( Thread.currentThread().getName() + " in ... 2" );
            p.arriveAndAwaitAdvance();
            System.out.println( Thread.currentThread().getName() + " OK." );
        };
        IntStream.rangeClosed( 1, count * 2 ).forEach( i -> {
            new Thread( r, "test-" + i ).start();
        } );
    }

    // countDown() 与 await()
    static void test2() {
        int count = 3;
        Phaser p = new Phaser( 1 );
        Runnable r = () -> {
            System.out.println( Thread.currentThread().getName() + " in ..." );
            p.awaitAdvance( p.getPhase() ); // countDownLatch.await()
            System.out.println( Thread.currentThread().getName() + " OK." );
        };
        IntStream.rangeClosed( 1, count ).forEach( i -> {
            new Thread( r, "test-" + i ).start();
        } );
        SleepUtils.second( 1 );
        System.out.println( "main ----" );
        p.arrive(); // countDownLatch.countDown()
    }

}
