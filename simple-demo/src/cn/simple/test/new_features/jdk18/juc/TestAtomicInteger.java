package cn.simple.test.new_features.jdk18.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class TestAtomicInteger extends Util {
    public static void main( String[] args ) {
	AtomicInteger atomicInt = new AtomicInteger( 0 );
	ExecutorService executor = Executors.newFixedThreadPool( 2 );
	IntStream.range( 0, 1000 ).forEach( i -> {
	    Runnable task = () -> atomicInt.accumulateAndGet( i, ( n, m ) -> n + m );
	    executor.submit( task );
	} );
	stop( executor );
	System.out.println( atomicInt.get() ); // => 499500
    }

    static void updateAndGet() {
	AtomicInteger atomicInt = new AtomicInteger( 0 );
	ExecutorService executor = Executors.newFixedThreadPool( 2 );
	IntStream.range( 0, 1000 ).forEach( i -> {
	    Runnable task = () -> atomicInt.updateAndGet( n -> n + 2 ); // 在内部累加
	    executor.submit( task );
	} );
	stop( executor );
	System.out.println( atomicInt.get() ); // => 2000
    }
}
