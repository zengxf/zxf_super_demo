package cn.simple.test.new_features.jdk1_8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TestTemporalAdjusters {
    public static void main( String[] args ) {
        LocalDate now = LocalDate.now();

        LocalDate next = now.with( TemporalAdjusters.nextOrSame( DayOfWeek.SUNDAY ) );
        System.out.println( next );

        next = now.with( TemporalAdjusters.lastDayOfMonth() );
        System.out.println( next );

        next = now.with( ( t ) -> t.plus( 1, ChronoUnit.DAYS ) ); // ×Ô¶¨Òå
        System.out.println( next );
    }
}
