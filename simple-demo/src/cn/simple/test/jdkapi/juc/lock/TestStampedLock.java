package cn.simple.test.jdkapi.juc.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * 还有乐观策略的读写锁
 * 
 * <p>
 * Created by zengxf on 2018-03-08
 */
public class TestStampedLock {

    public static void main( String[] args ) {
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
