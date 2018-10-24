package cn.simple.test.temp;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.stream.LongStream;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {
    public static void main( String[] args ) {
        LocalDate start = LocalDate.parse( "2018-09-23" );
        LocalDate end = LocalDate.parse( "2018-10-23" );
        Period until = start.until( end );
        System.out.println( until );
        long days = ChronoUnit.DAYS.between(start, end);
        System.out.println( days );
        LongStream.rangeClosed( 0, days )
                .boxed()
                .map( start::plusDays )
                .map( LocalDate::toString )
                .forEach( System.out::println );
    }

}