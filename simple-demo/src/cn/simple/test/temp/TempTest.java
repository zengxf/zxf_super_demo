
package cn.simple.test.temp;

import java.util.Date;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {
    public static void main( String[] args ) {
        String s = String.format( "%tY%<tm%<td-%tY%<tm%<td", new Date(), new Date() );
        System.out.println( s );
    }
}