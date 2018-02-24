package cn.simple.test.jdkapi.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * park() 得加对象，jstack 才能看的到<br>
 * unpark() 得一个一个搞
 * 
 * <p>
 * Created by zengxf on 2018-02-22
 */
public class TestLockSupport {

    public static void main( String[] args ) throws InterruptedException {
        TestLockSupportInner lock = new TestLockSupportInner();
        Runnable r = () -> {
            System.out.println( Thread.currentThread().getName() + " --------->" );
            LockSupport.park( lock );
            System.out.println( Thread.currentThread().getName() + " ---------> done" );
        };
        Thread t1 = new Thread( r );
        t1.start();
        Thread t2 = new Thread( r );
        t2.start();
        Thread.sleep( 1000L );
        System.out.println( "main --->" );
        LockSupport.unpark( t1 );
        LockSupport.unpark( t2 );
    }

    static class TestLockSupportInner {
    }

}
