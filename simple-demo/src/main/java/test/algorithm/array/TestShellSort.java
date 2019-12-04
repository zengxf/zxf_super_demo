package test.algorithm.array;

import java.util.Arrays;

/**
 * 希尔排序：跨度插入排序
 * <p>
 * 先分成 D1 个组，以距离为 D1 的倍数选；然后 D2, ... Dj 直到为 1，一般(Di /= 2) <br>
 * 然后再对组进行插入排序 <br>
 * 
 * <p>
 * Created by zengxf on 2018-03-07
 */
public class TestShellSort {

    public static void main( String[] args ) {
        int[] arr = { 1, 56, 23, 54, 2, 43, 65 };
        System.out.println( Arrays.toString( arr ) );
        shellSort( arr );
        System.out.println( Arrays.toString( arr ) );
    }

    public static void shellSort( int[] array ) {
        int len = array.length;
        int temp, gap = len / 2;
        while ( gap > 0 ) {
            for ( int i = gap; i < len; i++ ) {
                temp = array[i];
                int preIndex = i - gap;
                while ( preIndex >= 0 && array[preIndex] > temp ) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            System.out.println( Arrays.toString( array ) + "\t" + gap );
            gap /= 2;
        }
    }

    public static void shellSort1( int[] data ) {
        int gap = 2;
        // 计算出最大的h值
        int h = 1;
        while ( h <= data.length / gap ) {
            h = h * gap + 1;
        }
        while ( h > 0 ) {
            for ( int i = h; i < data.length; i += h ) {
                if ( data[i] < data[i - h] ) { // 左边的比右边的大
                    int currentNumber = data[i];
                    int j = i - h;
                    while ( j >= 0 && data[j] > currentNumber ) {
                        data[j + h] = data[j];
                        j -= h;
                    }
                    data[j + h] = currentNumber;
                }
            }
            // 计算出下一个h值
            h = ( h - 1 ) / gap;
        }
    }

}
