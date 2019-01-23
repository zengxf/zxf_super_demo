package cn.simple.test.jdkapi.juc.lock;

import java.util.concurrent.locks.StampedLock;

import cn.simple.util.SleepUtils;

/**
 * 还有乐观策略的读写锁
 * 
 * <p>
 * Created by zengxf on 2018-03-08
 */
public class TestStampedLock {

    public static void main( String[] args ) {
        test_loop();
    }

    static void test_loop() {
        StampedLock sl = new StampedLock();

        Runnable r1 = () -> {
            long stamp = sl.writeLock();
            try { // 写
                SleepUtils.second( 100 );
            } finally {
                sl.unlockWrite( stamp );
            }
        };
        Runnable r2 = () -> {
            long readStamp = sl.tryOptimisticRead();
            // 读
            if ( !sl.validate( readStamp ) ) {
                readStamp = sl.readLock();
                try { // 乐观锁无效，再读
                } finally {
                    sl.unlockRead( readStamp );
                }
            }
        };
        new Thread( r1, "write" ).start();
        SleepUtils.second( 1 );
        Thread read = new Thread( r2, "read" );
        read.start();
        SleepUtils.second( 1 );
        read.interrupt();
        System.out.println( "read interrupt" );
    }

    static void test_common() {
        StampedLock sl = new StampedLock();

        long stamp = sl.writeLock();
        try { // 写
        } finally {
            sl.unlockWrite( stamp );
        }

        long readStamp = sl.tryOptimisticRead();
        // 读
        if ( !sl.validate( readStamp ) ) {
            readStamp = sl.readLock();
            try { // 乐观锁无效，再读
            } finally {
                sl.unlockRead( readStamp );
            }
        }
    }

}
