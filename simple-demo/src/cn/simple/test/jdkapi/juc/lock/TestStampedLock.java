package cn.simple.test.jdkapi.juc.lock;

import java.util.concurrent.locks.StampedLock;

public class TestStampedLock {

    public static void main( String[] args ) {
        StampedLock sl = new StampedLock();

        long stamp = sl.writeLock();
        try {
        } finally {
            sl.unlockWrite( stamp );
        }

        long readStamp = sl.tryOptimisticRead();
        if ( !sl.validate( readStamp ) ) {
            readStamp = sl.readLock();
            try {
            } finally {
                sl.unlockRead( readStamp );
            }
        }
    }

}
