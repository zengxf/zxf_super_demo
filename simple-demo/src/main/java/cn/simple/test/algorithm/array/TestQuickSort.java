package cn.simple.test.algorithm.array;

import java.util.Arrays;

/**
 * 快速排序：找一个中心点，小的放左边，大的放右边
 * 
 * <p>
 * Created by zengxf on 2018-02-23
 */
public class TestQuickSort {

    public static void main( String[] args ) {
        int[] arr = { 23, 54, 2, 43, 65, 3 };
        System.out.println( Arrays.toString( arr ) );
         quickSort( arr, 0, arr.length - 1 );
//        quickSort1( arr );
        System.out.println( Arrays.toString( arr ) );
    }

    public static void quickSort( int[] array, int start, int end ) {
        if ( array.length < 1 || start < 0 || end >= array.length || start > end )
            return;
        int smallIndex = partition( array, start, end );
        if ( smallIndex > start )
            quickSort( array, start, smallIndex - 1 );
        if ( smallIndex < end )
            quickSort( array, smallIndex + 1, end );
    }

    public static int partition( int[] array, int start, int end ) {
        int pivot = (int) ( start + Math.random() * ( end - start + 1 ) );
        int smallIndex = start - 1;
        swap( array, pivot, end );
        for ( int i = start; i <= end; i++ )
            if ( array[i] <= array[end] ) {
                smallIndex++;
                if ( i > smallIndex )
                    swap( array, i, smallIndex );
            }
        return smallIndex;
    }

    public static void swap( int[] array, int i, int j ) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /// ------------------
    /// ------------------
    /// ------------------

    public static void quickSort1( int[] arr ) {
        qsort1( arr, 0, arr.length - 1 );
    }

    private static void qsort1( int[] arr, int low, int high ) {
        if ( low < high ) {
            int pivot = partition1( arr, low, high ); // 将数组分为两部分
            qsort1( arr, low, pivot - 1 ); // 递归排序左子数组
            qsort1( arr, pivot + 1, high ); // 递归排序右子数组
        }
    }

    private static int partition1( int[] arr, int low, int high ) {
        int pivot = arr[low]; // 枢轴记录
        while ( low < high ) {
            while ( low < high && arr[high] >= pivot )
                --high;
            arr[low] = arr[high]; // 交换比枢轴小的记录到左端
            while ( low < high && arr[low] <= pivot )
                ++low;
            arr[high] = arr[low]; // 交换比枢轴小的记录到右端
        }
        // 扫描完成，枢轴到位
        arr[low] = pivot;
        // 返回的是枢轴的位置
        return low;
    }

}
