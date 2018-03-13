
package cn.simple.test.temp;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) throws InterruptedException {
        LocalDate d1 = LocalDate.now().withDayOfMonth( 1 );
        System.out.println( d1.get( ChronoField.ALIGNED_WEEK_OF_YEAR ) );
        LocalDate d2= LocalDate.now()
                .withYear( 2018 )
                .withMonth( 3 )
                .withDayOfMonth( 31 );
        System.out.println( d2 );
        System.out.println( d2.get( ChronoField.ALIGNED_WEEK_OF_YEAR ) );
    }

}