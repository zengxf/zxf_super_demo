package cn.simple.test.temp;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

// M:\project\zxf_super_demo\simple-demo\bin\main\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) {
        int t = 183;
        int[] arr = { 180, 3, 181, 2, 4 };

        Set<Integer> exists = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        IntStream.of( arr )
                .forEach( set::add );
        for ( int ind = 0; ind < arr.length; ind++ ) {
            int i = arr[ind];
            int tmp = t - i;
            if ( exists.contains( i ) )
                continue;
            if ( set.contains( tmp ) ) {
                exists.add( i );
                exists.add( tmp );
                System.out.println( i + ", " + tmp );
            }
        }
    }

}