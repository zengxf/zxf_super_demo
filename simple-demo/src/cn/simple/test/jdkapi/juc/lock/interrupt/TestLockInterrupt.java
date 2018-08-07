package cn.simple.test.jdkapi.juc.lock.interrupt;

import java.util.concurrent.locks.ReentrantLock;

import cn.simple.util.SleepUtils;

public class TestLockInterrupt {

    public static void main( String[] args ) {
        ReentrantLock lock = new ReentrantLock();
        Runnable r = () -> {
            try {
                lock.lockInterruptibly();
            } catch ( InterruptedException e ) {
                e.printStackTrace();
                return;
            }
            try {
                System.out.println( Thread.currentThread()
                        .getName() + " in ..." );
                SleepUtils.second( 2 );
                System.out.println( Thread.currentThread()
                        .getName() + " out ..." );
            } finally {
                lock.unlock();
            }
        };

        Thread t1 = new Thread( r, "test-1" );
        Thread t2 = new Thread( r, "test-2" );

        t1.start();
        SleepUtils.millisecond( 100 );
        t2.start();
        System.out.println( "t2 start" );

        SleepUtils.millisecond( 100 );
        System.out.println( "t2 interrupt" );
        t2.interrupt();
    }

}
