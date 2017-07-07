package cn.simple.test.algorithm.recursive;

import java.util.stream.LongStream;

// -Xss68K
public class TestRecursive {
    public static void main( String[] args ) throws InterruptedException {
	long result = 0;
	long n = 800;
	result = factorialTailRecursive( n );
	// result = factorialRecursive( n );
	result = factorialStreams( n );
	result = factorialIterative( n );
	System.out.println( result );
    }

    // β�ݹ� - java û���Ż���û����
    static long factorialTailRecursive( long n ) {
	return factorialHelper( 1, n );
    }

    static long factorialHelper( long acc, long n ) {
	return n == 1 ? acc : factorialHelper( acc * n, n - 1 );
    }

    // ��ͳ�ݹ�
    static long factorialRecursive( long n ) {
	return n == 1 ? 1 : n * factorialRecursive( n - 1 );
    }

    // java8 ��
    static long factorialStreams( long n ) {
	return LongStream.rangeClosed( 1, n ).reduce( 1, ( long a, long b ) -> a * b );
    }

    // ����
    static long factorialIterative( long n ) {
	long r = 1;
	for ( long i = 1; i <= n; i++ ) {
	    r *= i;
	}
	return r;
    }
}
