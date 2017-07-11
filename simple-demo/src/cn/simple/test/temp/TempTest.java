
package cn.simple.test.temp;

import java.io.IOException;
import java.util.stream.Stream;

public class TempTest {

    public static void main( String[] args ) {
	String prefix = "test-";
	Stream.of( "ss", "bb" ).forEach( str -> System.out.print( prefix + str ) );
	byte[] classBytes = "fuck".getBytes();
	cn.simple.test.temp.TempTest.write( classBytes );
    }

    public static void write( byte[] classBytes ) {
	try {
	    java.nio.file.Files.write( java.nio.file.Paths.get( "C:/Users/Administrator/Desktop/a.txt" ), classBytes );
	} catch ( IOException e ) {
	    e.printStackTrace();
	}
    }

}
