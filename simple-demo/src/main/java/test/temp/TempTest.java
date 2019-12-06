package test.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// M:\zxf-demo-github\zxf_super_demo\simple-demo\bin\main\test\temp
public class TempTest {

    public static void main( final String[] args ) {
        List<int[]> list = new ArrayList<>();
        printTotal( 4, list );
        List<String> strList = list.stream()
                .map( Arrays::toString )
                .collect( Collectors.toList() );
        System.out.println( strList );
        System.out.println( strList.size() );
    }

    public static final void printTotal( final int n, List<int[]> list ) {
        for ( int i = 1; i <= n; i++ ) {
            print_nCr( n, i, list );
        }
    }

    public static final void print_nCr( final int n, final int r, List<int[]> list ) {
        int[] res = new int[r];
        for ( int i = 0; i < res.length; i++ ) {
            res[i] = i + 1;
        }
        boolean done = false;
        while ( !done ) {
            int[] newArr = Arrays.copyOf( res, res.length );
            list.add( newArr );
            done = getNext( res, n, r );
        }
    }

    public static final boolean getNext( final int[] num, final int n, final int r ) {
        int target = r - 1;
        num[target]++;
        if ( num[target] > ( ( n - ( r - target ) ) + 1 ) ) {
            while ( num[target] > ( ( n - ( r - target ) ) ) ) {
                target--;
                if ( target < 0 ) {
                    break;
                }
            }
            if ( target < 0 ) {
                return true;
            }
            num[target]++;
            for ( int i = target + 1; i < num.length; i++ ) {
                num[i] = num[i - 1] + 1;
            }
        }
        return false;
    }
}
