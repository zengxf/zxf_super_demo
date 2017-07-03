package cn.simple.test.new_features.jdk17.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinPoolTest {
    public static void main( String[] args ) throws Exception {
	ForkJoinPool forkJoinPool = new ForkJoinPool( 4 );

	PiEstimateTask task = new PiEstimateTask( 0, 1_000_000_000, 10_000_000 );
	Future<Double> future = forkJoinPool.submit( task ); // ������

	double pi = future.get();
	System.out.println( "(my  ) �� ��ֵ��" + pi );
	System.out.println();
	System.out.println( "(java) �� ��ֵ��" + Math.PI );
	System.out.println( "future ָ��Ķ����� task ��" + ( future == task ) );

	forkJoinPool.shutdown(); // ���̳߳ط��͹رյ�ָ��
    }

    static void forkJoin() {
	ForkJoinPool forkJoinPool = new ForkJoinPool( 8 );

	// ���� 10 ����ָ�������ٽ�ֵΪ 1 ǧ��
	PiEstimateTask task = new PiEstimateTask( 0, 1_000_000_000, 10_000_000 );

	double pi = forkJoinPool.invoke( task ); // ������ֱ������ִ����Ϸ��ؽ��

	System.out.println( "(my  ) �� ��ֵ��" + pi );
	System.out.println();
	System.out.println( "(java) �� ��ֵ��" + Math.PI );

	forkJoinPool.shutdown(); // ���̳߳ط��͹رյ�ָ��
    }
}
