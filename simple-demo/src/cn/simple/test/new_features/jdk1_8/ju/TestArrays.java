package cn.simple.test.new_features.jdk1_8.ju;

import java.util.Arrays;

public class TestArrays {
    static int[] arr = new int[10];

    public static void main( String[] args ) {
	test_fill();
	print();
	
	test_parallelPrefix();
	print();
	
	test_setAll();
	print();
    }

    static void test_setAll() {
	Arrays.setAll( arr, i -> 2 * i );
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
