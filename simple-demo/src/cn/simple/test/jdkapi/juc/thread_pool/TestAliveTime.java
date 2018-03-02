package cn.simple.test.jdkapi.juc.thread_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import cn.simple.util.SleepUtils;
import static cn.simple.util.ThreadInfoUtils.*;

/**
 * 超出 core 的线程，会执行完任务后最多存活 keepAliveTime，然后销毁
 * 
 * <p>
 * Created by zengxf on 2018-02-28
 */
public class TestAliveTime {

    public static void main( String[] args ) {
        BlockingQueue<Runnable> q = new ArrayBlockingQueue<Runnable>( 1 );
        ThreadPoolExecutor p = new ThreadPoolExecutor( 2, 3, 1, TimeUnit.SECONDS, q );
        IntStream.rangeClosed( 1, 4 ).forEach( i -> {
            p.execute( () -> {
                System.out.println( "" + i + "\t" + Thread.currentThread().getName() + " in ---" );
                SleepUtils.second( 1 );
                System.out.println( "" + i + "\t" + Thread.currentThread().getName() + " exit ---" );
            } );
        } );

        printInfo();
        System.out.println( "active-size: " + p.getActiveCount() );
        System.out.println( "max-pool-size: " + p.getMaximumPoolSize() );
        System.out.println( "queue-size: " + p.getQueue().size() );
        SleepUtils.second( 1 );
        System.out.println();

        printInfo();
        System.out.println( "active-size: " + p.getActiveCount() );
        System.out.println( "queue-size: " + p.getMaximumPoolSize() );
        System.out.println( "queue-size: " + p.getQueue().size() );
        SleepUtils.second( 1 );
        System.out.println();

        printInfo();
        System.out.println( "active-size: " + p.getActiveCount() );
        System.out.println( "queue-size: " + p.getMaximumPoolSize() );
        System.out.println( "queue-size: " + p.getQueue().size() );

        p.shutdown();
    }

}
