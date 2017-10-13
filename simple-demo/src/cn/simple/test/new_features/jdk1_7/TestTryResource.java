package cn.simple.test.new_features.jdk17;

import java.io.Closeable;
import java.io.IOException;

/**
 * 看反编译后的语法
 * 
 * <p>
 * Created by zxf on 2017-07-28
 */
public class TestTryResource {
    public static void main( String[] args ) {
	try ( MyAutoClose my = new MyAutoClose() ) {
	    my.test();
	} catch ( IOException e ) {
	    System.out.println( "io exception" );
	}
    }
}

class MyAutoClose implements Closeable {

    @Override
    public void close() throws IOException {
	System.out.println( "my auto close" );
    }

    public void test() throws IOException {
	System.out.println( "test" );
    }

}