package cn.simple.test.thread;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TestDelayQueue {
    public static void main( String[] args ) throws InterruptedException {
	DelayQueue<MyDelayed> queue = new DelayQueue<>();
	new Thread( () -> {
	    System.out.println( "## - 1 - " + queue.poll() );
	    try {
		Thread.sleep( 100L );
	    } catch ( Exception e ) {
		e.printStackTrace();
	    }
	    try {
		System.out.println( "## - 2 - start " );
		System.out.println( "## - 2 - " + queue.take() );
		System.out.println( "## 0 == " + System.currentTimeMillis() );
	    } catch ( Exception e ) {
		e.printStackTrace();
	    }
	} ).start();
	queue.put( new MyDelayed( "d" ) );
	System.out.println( "-- 0 == " + System.currentTimeMillis() );
	// queue.put( "e" );
	// System.out.println( "-- 1" );

    }

    static class MyDelayed implements Delayed {

	long s = 2; // 1 s

	String sign;
	long   time = 0;

	public MyDelayed( String sign ) {
	    super();
	    this.sign = sign;
	    time = TimeUnit.SECONDS.toNanos( 1 ) + System.nanoTime();
	    System.out.println( time );
	}

	@Override
	public int compareTo( Delayed o ) {
	    return 0;
	}

	@Override
	public long getDelay( TimeUnit unit ) { // DelayQueue ÓÃµÄÊÇ NANOSECONDS
	    long convert = unit.convert( time - System.nanoTime(), TimeUnit.NANOSECONDS );
	    System.out.println( "unit: " + unit );
	    System.out.println( "c: " + convert );
	    return convert;
	}

    }
}
