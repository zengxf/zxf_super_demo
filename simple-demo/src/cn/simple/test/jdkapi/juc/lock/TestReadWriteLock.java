package cn.simple.test.jdkapi.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <pre>
 * ThreadLocal.get() 相对而已比较耗时。
 * 共享锁获取时，设置状态是：c + SHARED_UNIT，这样 c >>> SHARED_SHIFT 就准了；c + SHARED_UNIT 相当于共享标识位的 c++
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2018-02-24
 */
public class TestReadWriteLock {

    public static void main( String[] args ) {
        ReadWriteLock rwl = new ReentrantReadWriteLock();
        Lock readLock = rwl.readLock();
        Lock writeLock = rwl.writeLock();

        Runnable read = () -> {
            System.out.println( Thread.currentThread().getName() + " readLock init ...." );
            sleep( 1000L );
            readLock.lock();
            try {
                System.out.println( Thread.currentThread().getName() + " read ...." );
                sleep( 2000L );
                System.out.println( Thread.currentThread().getName() + " read done!" );
            } finally {
                readLock.unlock();
            }
        };

        Runnable write = () -> {
            sleep( 1200L );
            System.out.println( Thread.currentThread().getName() + " writeLock init ...." );
            writeLock.lock();
            try {
                System.out.println( Thread.currentThread().getName() + " write ...." );
                sleep( 1000L );
                System.out.println( Thread.currentThread().getName() + " write done!" );
            } finally {
                writeLock.unlock();
            }
        };

        new Thread( read, "test-read-0" ).start();
        new Thread( write, "test-write" ).start();
        sleep( 500L );
        new Thread( read, "test-read-2" ).start();
    }

    static void sleep( long millis ) {
        try {
            Thread.sleep( millis );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }
}
