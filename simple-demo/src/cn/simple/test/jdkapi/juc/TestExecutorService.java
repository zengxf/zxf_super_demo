package cn.simple.test.jdkapi.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ���һ���߳�����ִ���ڼ���ʧ�ܶ���ֹ���򴴽�һ�����̡߳�
 * 
 * <p>
 * Created by zengxf on 2017-09-25
 */
public class TestExecutorService {
    public static void main( String[] args ) {
        ExecutorService exe = Executors.newFixedThreadPool( 3 );
        for ( int i = 0; i < 12; i++ ) {
            int j = i;
            exe.execute( () -> {
                System.out.println( "j: " + j + ", thread: " + Thread.currentThread().getName() );
                if ( j > 5 )
                    throw new RuntimeException( "error - " + j );
            } );
        }
        exe.shutdown();
    }
}
