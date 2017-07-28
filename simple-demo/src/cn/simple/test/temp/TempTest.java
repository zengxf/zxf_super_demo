
package cn.simple.test.temp;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TempTest {

    public static void main( String[] args ) {
	String folder = "/C:/Users/Administrator/Desktop/aaa/debug";
	Path folder1 = Paths.get( folder );
	System.out.println( folder1 );
    }

}