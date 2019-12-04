package test.temp;

// M:\zxf-demo-github\zxf_super_demo\simple-demo\bin\main\test\temp
public class TempTest {

    public static void main( String[] args ) {
        System.out.println( multiplication( 100 ) );
        System.out.println( formulaTotal( 4 ) );
    }

    static double formulaTotal( long n ) {
        double sum = 0;
        for ( long i = 1; i < n; i++ ) {
            sum += formula( n, i );
        }
        sum += 1;
        return sum;
    }

    static double formula( long n, long m ) {
        return multiplication( n ) / ( multiplication( m ) * multiplication( n - m ) );
    }

    static double multiplication( long v ) {
        double m = 1;
        while ( v > 0 ) {
            m *= v;
            v--;
        }
        return m;
    }
}
