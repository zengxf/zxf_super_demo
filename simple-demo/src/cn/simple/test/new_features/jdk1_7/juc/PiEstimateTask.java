package cn.simple.test.new_features.jdk1_7.juc;

import java.util.concurrent.RecursiveTask;

public class PiEstimateTask extends RecursiveTask<Double> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final long	      begin;
    private final long	      end;
    private final long	      threshold;	    // �ָ�������ٽ�ֵ

    public PiEstimateTask( long begin, long end, long threshold ) {
	this.begin = begin;
	this.end = end;
	this.threshold = threshold;
    }

    @Override
    protected Double compute() {
	if ( end - begin <= threshold ) {

	    int sign = 1; // ���ţ�ȡ 1 ���� -1
	    double result = 0.0;
	    for ( long i = begin; i < end; i++ ) {
		result += sign / ( i * 2.0 + 1 );
		sign = -sign;
	    }

	    return result * 4;
	}

	// �ָ�����
	long middle = ( begin + end ) / 2;
	PiEstimateTask leftTask = new PiEstimateTask( begin, middle, threshold );
	PiEstimateTask rightTask = new PiEstimateTask( middle, end, threshold );

	leftTask.fork(); // �첽ִ�� leftTask
	rightTask.fork(); // �첽ִ�� rightTask

	double leftResult = leftTask.join(); // ������ֱ�� leftTask ִ����Ϸ��ؽ��
	double rightResult = rightTask.join(); // ������ֱ�� rightTask ִ����Ϸ��ؽ��

	return leftResult + rightResult; // �ϲ����
    }

}