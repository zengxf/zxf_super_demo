package cn.simple.test.new_features.jdk18;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.chrono.IsoChronology;
import java.util.Date;

public class TestDate {
    public static void main( String[] args ) {
	Clock clock = Clock.systemDefaultZone();

	long millis = clock.millis();
	long millis2 = System.currentTimeMillis();
	System.out.println( millis );
	System.out.println( millis2 );

	Instant instant = clock.instant();
	Date legacyDate = Date.from( instant ); // legacy java.util.Date
	System.out.println( String.format( "%tF %<tT", legacyDate ) );

	LocalTime late = LocalTime.of( 23, 59, 59 );
	System.out.println( late );

	LocalDate today = LocalDate.now();
	System.out.println( today );

	LocalDateTime date = LocalDateTime.of( 2014, Month.DECEMBER, 31, 23, 59, 59 );
	System.out.println( date );

	System.out.println( IsoChronology.INSTANCE.isLeapYear( 2016 ) ); // 判断是不是闰年
    }
}
