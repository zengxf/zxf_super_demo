package cn.simple.test.algorithm.array;

import java.util.Arrays;

/**
 * 选择排序：从未排序的队列中选择最小的，放在已排序的队列最尾
 * 
 * <p>
 * Created by zengxf on 2018-03-07
 */
public class TestSelectionSort {

    public static void main( String[] args ) {
        int[] arr = { 23, 54, 2, 43, 65, 3 };
        System.out.println( Arrays.toString( arr ) );
        selectionSort( arr );
        System.out.println( Arrays.toString( arr ) );
    }

    public static void selectionSortA( int[] a ) {
        for ( int i = 0; i < a.length; i++ ) {
            int minValue = a[i];
            int minIndex = i; // 将当前下标定义为最小值下标
            for ( int j = i + 1; j < a.length; j++ ) {
                if ( a[j] < minValue ) {// a[j] < temp 从小到大排序；a[j] > temp 从大到小排序
                    minValue = a[j];
                    minIndex = j; // 如果有小于当前最小值的关键字将此关键字的下标赋值给flag
                }
            }
            if ( minIndex != i ) {
                a[minIndex] = a[i];
                a[i] = minValue;
            }
        }
    }

    public static void selectionSort( int[] array ) {
        for ( int i = 0; i < array.length; i++ ) {
            int minIndex = i;
            for ( int j = i; j < array.length; j++ ) {
                if ( array[j] < array[minIndex] ) // 找到最小的数
                    minIndex = j; // 将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

}
