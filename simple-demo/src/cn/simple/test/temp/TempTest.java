
package cn.simple.test.temp;

import java.math.BigDecimal;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) throws CloneNotSupportedException {
        Double c = Double.POSITIVE_INFINITY;
//        System.out.println( c );
//        System.out.println( c .equals(  Double.NaN ));
//        System.out.println( c.isNaN() );
         System.out.println( String.format( "%s", BigDecimal.valueOf(c ) ) );
    }

}