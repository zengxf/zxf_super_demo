package cn.simple.test.new_features.jdk18.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

public class TestLongAccumulator extends Util {

    public static void main( String[] args ) {
	// test1();
	test2();
    }

    static void test2() {
	LongBinaryOperator op = Long::sum;
	LongAccumulator accumulator = new LongAccumulator( op, 1L );
	accumulator.accumulate( 10 );
	accumulator.accumulate( 10 );
	System.out.println( accumulator.get() );
	System.out.println( accumulator.getThenReset() );
    }

    static void test1() {
	LongBinaryOperator op = ( x, y ) -> 2 * x + y;
	LongAccumulator accumulator = new LongAccumulator( op, 1L );
	ExecutorService executor = Executors.newFixedThreadPool( 2 );
	int end = 4;
	IntStream.range( 0, end ).forEach( i -> executor.submit( () -> accumulator.accumulate( i ) ) );
	stop( executor );
	System.out.println( accumulator.getThenReset() ); // => 2539
	IntStream.range( 0, end ).forEach( System.out::println );
    }

}
