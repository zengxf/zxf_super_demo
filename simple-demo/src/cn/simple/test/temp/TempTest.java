
package cn.simple.test.temp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TempTest {

    public static void main( String[] args ) throws IOException {
        Path p = Paths.get( "/a-test.txt" );
        Files.write( p, "fuck".getBytes() );
        System.out.println( p );
    }

}