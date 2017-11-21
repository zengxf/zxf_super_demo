
package cn.simple.test.temp;

import java.io.IOException;
import java.text.ParseException;
import java.util.stream.Stream;

public class TempTest {

    public static void main( String[] args ) throws IOException, InterruptedException, ParseException {
       System.out.println( Math.round( 3.4 ) );
       System.out.println( Math.round( 3.5 ) );
       System.out.println( Double.MAX_VALUE + 2 );
    }

    public static double[] toDoubleArr( int v, int len ) {
        int fv = 1 << len | v; // 填充
        String str = Integer.toBinaryString( fv );
        String[] arr = str.split( "" );
        return Stream.of( arr ).skip( 1 ).mapToDouble( Double::parseDouble ).toArray();
    }

}