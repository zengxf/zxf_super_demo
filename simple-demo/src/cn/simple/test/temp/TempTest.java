
package cn.simple.test.temp;

import java.io.IOException;
import java.util.function.Predicate;

public class TempTest {

    public static void main( String[] args ) throws IOException {
	boolean s = Predicate.isEqual( "a" ).or( Predicate.isEqual( "b" ) ).test( "b" );
	System.out.println( s );
    }

}