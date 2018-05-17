
package cn.simple.test.temp;

import java.math.BigDecimal;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) throws CloneNotSupportedException {
        System.out.println( BigDecimal.valueOf( 12.32 )
                .setScale( 4 )
                .doubleValue() );
    }

}