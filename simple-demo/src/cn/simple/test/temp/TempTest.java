
package cn.simple.test.temp;

import java.time.LocalDate;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) throws InterruptedException {
        System.out.println( LocalDate.now().plusMonths( 1 ).getMonthValue() );
    }

}