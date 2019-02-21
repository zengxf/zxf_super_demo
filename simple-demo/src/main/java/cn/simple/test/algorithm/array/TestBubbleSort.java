package cn.simple.test.algorithm.array;

import java.util.Arrays;

/**
 * 冒泡排序：每次选择一个最大的放到队尾
 * 
 * <p>
 * Created by zengxf on 2018-03-07
 */
public class TestBubbleSort {

    public static void main( String[] args ) {
        int[] arr = { 23, 54, 2, 43, 65, 3 };
        System.out.println( Arrays.toString( arr ) );
        bubbleSort( arr );
        System.out.println( Arrays.toString( arr ) );
    }

    public static void bubbleSort( int[] arr ) {
        int temp = 0;
        for ( int i = arr.length - 1; i > 0; i-- ) { // 每次需要排序的长度
            for ( int j = 0; j < i; j++ ) { // 从第一个元素到第i个元素
                if ( arr[j] > arr[j + 1] ) { // 左边的大
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp; // 移动到右边去
                }
            }
        }
    }

    public static int[] bubbleSortA( int[] array ) {
        int len = array.length;
        if ( len == 0 )
            return array;
        for ( int i = 0; i < len; i++ )
            for ( int j = 0; j < len - 1 - i; j++ )
                if ( array[j + 1] < array[j] ) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }
}
