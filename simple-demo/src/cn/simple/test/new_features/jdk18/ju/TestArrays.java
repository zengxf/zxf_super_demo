package cn.simple.test.new_features.jdk18.ju;

import java.util.Arrays;

public class TestArrays {
    static int[] arr = new int[10];

    public static void main( String[] args ) {
	test_fill();
	test_parallelPrefix();

	print();
    }

    // 填充相同的值
    static void test_parallelPrefix() {
	Arrays.parallelPrefix( arr, ( i1, i2 ) -> i1 + i2 );
    }

    // 填充相同的值
    static void test_fill() {
	Arrays.fill( arr, 1 );
    }

    static void print() {
	System.out.println( Arrays.toString( arr ) );
    }
}
