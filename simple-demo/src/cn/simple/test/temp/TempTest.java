
package cn.simple.test.temp;

import java.util.Base64;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) throws CloneNotSupportedException {
       String str = Base64.getEncoder().encodeToString( "ab------".getBytes() );
       System.out.println( str ); 
    }

}