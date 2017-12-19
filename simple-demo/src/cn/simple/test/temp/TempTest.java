
package cn.simple.test.temp;

import java.util.Arrays;

public class TempTest {

    public static void main( String[] args ) throws Exception {
        String[] arr = Arrays.asList( "a", "b" ).stream().map( s -> s ).toArray( i -> new String[1] );
        System.out.println( Arrays.toString( arr ) );
    }

}