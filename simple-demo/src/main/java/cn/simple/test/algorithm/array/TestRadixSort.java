package cn.simple.test.algorithm.array;

import java.util.Arrays;

public class TestRadixSort {

    public static void main( String[] args ) {
        int[] arr = { 23, 54, 2, 3, 98, 34, 54, 56, 34, 43, 65, 123, 3 };
        System.out.println( Arrays.toString( arr ) );
        radixSort( arr, 1000 );
        System.out.println( Arrays.toString( arr ) );
    }

    static void radixSort( int[] array, int maxBase ) {
        int base = 1; // 代表位数对应的数：1, 10, 100...
        int length = array.length;
        int[][] bucket = new int[10][length];
        int[] order = new int[10]; // 用于保存每个桶里有多少个数字
        while ( base < maxBase ) {
            for ( int num : array ) { // 将数组里的每个数字放在相应的桶里
                int digit = ( num / base ) % 10;
                int index = order[digit]++;
                bucket[digit][index] = num;
            }
            for ( int i = 0, k = 0; i < 10; i++ ) { // 覆盖到原数组中，保存排序结果
                if ( order[i] != 0 ) {
                    for ( int j = 0; j < order[i]; j++ ) {
                        array[k++] = bucket[i][j];
                    }
                    order[i] = 0;
                }
            }
            base *= 10;
        }
    }

}
