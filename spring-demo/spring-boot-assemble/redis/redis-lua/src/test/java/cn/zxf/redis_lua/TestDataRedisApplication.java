package cn.zxf.redis_lua;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.zxf.redis_lua.demo.IDGenerator;

@RunWith( SpringRunner.class )
@SpringBootTest
public class TestDataRedisApplication {

    @Autowired
    private IDGenerator idGenerator;

    @Test
    public void test1() throws InterruptedException {
        System.out.println( "current-currentID:" + idGenerator.currentID() );
        int threadSize = 5;
        final CountDownLatch countDownLatch = new CountDownLatch( threadSize );
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for ( int i = 0; i < 10; i++ ) {
                    System.out.println( Thread.currentThread().getName() + " -> :" + idGenerator.nextID() );
                }
                countDownLatch.countDown();
            }
        };
        for ( int i = 0; i < threadSize; i++ ) {
            new Thread( runnable, "Thread" + i ).start();
        }
        countDownLatch.await();
        System.out.println( "current-currentID:" + idGenerator.currentID() );
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println( "current-currentID:" + idGenerator.currentID() );
        Integer threadSize = 5;
        final CountDownLatch countDownLatch = new CountDownLatch( threadSize );
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for ( int i = 0; i < 10; i++ ) {
                    System.out.println( Thread.currentThread().getName() + " -> :" + idGenerator.nextIDLua() );
                }
                countDownLatch.countDown();
            }
        };
        for ( int i = 0; i < threadSize; i++ ) {
            new Thread( runnable, "Thread" + i ).start();
        }
        countDownLatch.await();
        System.out.println( "current-currentID:" + idGenerator.currentID() );
    }
}
