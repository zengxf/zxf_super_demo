package cn.simple.test.new_features.jdk18.stream;

import java.util.concurrent.ForkJoinPool;

/**
 * list.parallelStream()
 * <p>
 * ��Ҫ����ʵ�������ֿ�����ʽ��������Ϊ������ ��������Ӧ���������������������������֡�
 * 
 * <p>
 * Created by zxf on 2017-04-24
 */
public class TestForkJoinPool {

    public static void main( String[] args ) throws Throwable {
	// -Djava.util.concurrent.ForkJoinPool.common.parallelism=5
	System.setProperty( "java.util.concurrent.ForkJoinPool.common.parallelism", "5" );
	ForkJoinPool commonPool = ForkJoinPool.commonPool();
	System.out.println( commonPool );
	System.out.println( commonPool.getParallelism() ); //
    }
}
