
package cn.simple.test.temp;

import java.util.stream.Stream;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) {
        Stream.of( "ab  \ta\r大  df　中　　在".split( "[ 　]+" ) )
                .forEach( System.out::println );
    }

}
