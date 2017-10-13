package cn.simple.test.new_features.jdk18.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class TestLongAdder extends Util {
    public static void main( String[] args ) {
	// LongAdder
	// �����̵߳ĸ��±ȶ�ȡ��Ƶ��ʱ�������ͨ����ԭ����ֵ�����ܸ���
	// ȱ���ǽϸߵ��ڴ濪������Ϊ�����ڴ��д�����һϵ�б���
	LongAdder adder = new LongAdder();
	ExecutorService executor = Executors.newFixedThreadPool( 2 );
	IntStream.range( 0, 1000 ).forEach( i -> executor.submit( adder::increment ) );
	stop( executor );
	System.out.println( adder.sumThenReset() ); // => 1000
	System.out.println( adder.sum() ); // => 0
    }
}
