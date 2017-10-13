package cn.simple.test.new_features.jdk1_7.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * �������ĺ�ʱ��ƽ�������ʱ Work-Stealing �����ʺϣ�<br>
 * ��Ϊ��ȡ����ʱҲ����Ҫ��ռ���ģ������ɶ����ʱ�����ģ�����ÿ���߳�ά��˫�˶���Ҳ����ɸ�����ڴ�����
 * 
 * <p>
 * Created by zxf on 2017-07-03
 */
public class WorkSteelingTest {

    public static void main( String[] args ) throws Exception {
	testForkJoinPool();
	testThreadPoolExecutor();
    }

    private static final int TASK_NUM	= 100;
    private static final int THREAD_NUM	= 4;

    public static void testForkJoinPool() throws InterruptedException {
	ForkJoinPool forkJoinPool = new ForkJoinPool( THREAD_NUM );

	long startTime = System.nanoTime();

	for ( int i = 1; i <= TASK_NUM; i++ ) {
	    SimpleAction task = new SimpleAction( i * 1 );
	    forkJoinPool.execute( task );
	}

	forkJoinPool.shutdown();
	forkJoinPool.awaitTermination( Long.MAX_VALUE, TimeUnit.MILLISECONDS );

	System.out.println( "����ȡ������������" + forkJoinPool.getStealCount() );

	long finishedTime = System.nanoTime();
	double time = ( finishedTime - startTime ) / 1E9;

	System.out.printf( "%-18s ��ʱ: %.3f ��\n\n", "ForkJoinPool", time );
    }

    public static void testThreadPoolExecutor() throws InterruptedException {
	ExecutorService threadPool = Executors.newFixedThreadPool( THREAD_NUM );

	long startTime = System.nanoTime();

	for ( int i = 1; i <= TASK_NUM; i++ ) {
	    SimpleRunnable task = new SimpleRunnable( i * 1 );
	    threadPool.execute( task );
	}

	threadPool.shutdown();
	threadPool.awaitTermination( Long.MAX_VALUE, TimeUnit.MILLISECONDS );

	long finishedTime = System.nanoTime();
	double time = ( finishedTime - startTime ) / 1E9;

	System.out.printf( "%-18s ��ʱ: %.3f ��\n\n", "ThreadPoolExecutor", time );
    }

    @SuppressWarnings( "serial" )
    static class SimpleAction extends RecursiveAction {

	private final int sleepTime;

	public SimpleAction( int sleepTime ) {
	    this.sleepTime = sleepTime;
	}

	@Override
	protected void compute() {
	    if ( sleepTime <= 10 ) {
		try {
		    Thread.sleep( sleepTime );
		} catch ( InterruptedException ex ) {
		    ex.printStackTrace( System.err );
		}
	    } else {
		int sleepTime1 = sleepTime / 2;
		// (sleepTime & 1) == 0 ��ʾ sleepTime Ϊż��
		int sleepTime2 = ( sleepTime & 1 ) == 0 ? sleepTime1 : sleepTime1 + 1;

		SimpleAction subTask1 = new SimpleAction( sleepTime1 );
		SimpleAction subTask2 = new SimpleAction( sleepTime2 );

		subTask1.fork();
		subTask2.fork();

		subTask1.join();
		subTask2.join();
	    }
	}
    }

    static class SimpleRunnable implements Runnable {

	private final int sleepTime;

	public SimpleRunnable( int sleepTime ) {
	    this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
	    try {
		Thread.sleep( sleepTime );
	    } catch ( InterruptedException ex ) {
		ex.printStackTrace( System.err );
	    }
	}
    }

}