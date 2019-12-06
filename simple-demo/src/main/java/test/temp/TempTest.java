package test.temp;

import java.util.Arrays;

// M:\zxf-demo-github\zxf_super_demo\simple-demo\bin\main\test\temp
public class TempTest {

    public static void main( final String[] args ) {
        printTotal( 4 );
    }

    public static final void printTotal( final int n ) {
        for ( int i = 1; i < n; i++ ) {
            print_nCr( n, i );
        }
    }

    public static final void print_nCr( final int n, final int r ) {
        int[] res = new int[r];
        for ( int i = 0; i < res.length; i++ ) {
            res[i] = i + 1;
        }
        boolean done = false;
        while ( !done ) {
            String v = Arrays.toString( res )
                    .replace( ", ", "" );
            System.out.print( v );
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
