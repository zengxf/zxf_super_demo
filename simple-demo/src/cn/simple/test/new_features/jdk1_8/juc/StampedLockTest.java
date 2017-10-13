package cn.simple.test.new_features.jdk18.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

class StampedLockTest extends Util {

    static int count = 0;

    public static void main( String[] args ) throws Throwable {
	ExecutorService executor = Executors.newFixedThreadPool( 2 );
	StampedLock lock = new StampedLock();
	executor.submit( () -> {
	    long stamp = lock.readLock();
	    try {
		if ( count == 0 ) {
		    stamp = lock.tryConvertToWriteLock( stamp ); // ����ת��Ϊд���������ٴν����ͼ���ʮ��ʵ��
		    if ( stamp == 0L ) {
			System.out.println( "Could not convert to write lock" );
			stamp = lock.writeLock(); // ������ǰ�̣߳�ֱ���п��õ�д��
		    }
		    count = 23;
		}
		System.out.println( count );
	    } finally {
		lock.unlock( stamp );
	    }
	} );
	stop( executor );
    }

    // �����ֹ���
    // * �ֹ����ڸո��õ���֮������Ч�ġ�д��������ȴ��ֹ۵Ķ������ͷš�
    // * ��д���ͷ�ʱ���ֹ۵Ķ� ����������Ч״̬�� ������ʹ���ֹ���ʱ������Ҫÿ���ڷ����κι���ɱ����֮��Ҫ���������ȷ ��������Ȼ��Ч
    static void testOptimisticRead() {
	ExecutorService executor = Executors.newFixedThreadPool( 2 );
	StampedLock lock = new StampedLock();
	executor.submit( () -> {
	    long stamp = lock.tryOptimisticRead();
	    try {
		System.out.println( "Optimistic Lock Valid: " + lock.validate( stamp ) );
		sleep( 1 );
		System.out.println( "Optimistic Lock Valid: " + lock.validate( stamp ) );
		sleep( 2 );
		System.out.println( "Optimistic Lock Valid: " + lock.validate( stamp ) );
		sleep( 2 );
		System.out.println( "Optimistic Lock Valid: " + lock.validate( stamp ) );
	    } finally {
		lock.unlock( stamp );
	    }
	} );
	executor.submit( () -> {
	    long stamp = lock.writeLock();
	    try {
		System.out.println( "Write Lock acquired" );
		sleep( 2 );
	    } finally {
		lock.unlock( stamp );
		System.out.println( "Write done" );
	    }
	} );
	stop( executor );
    }

}
