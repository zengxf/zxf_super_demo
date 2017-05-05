package cn.simple.test.new_features.jdk18.date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

public class TestDateTime {
    public static void main( String[] args ) {
	LocalDateTime sylvester = LocalDateTime.of( 2014, Month.DECEMBER, 31, 23, 59, 59 );
	DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
	System.out.println( dayOfWeek ); // WEDNESDAY
	Month month = sylvester.getMonth();
	System.out.println( month ); // DECEMBER
	long minuteOfDay = sylvester.getLong( ChronoField.MINUTE_OF_DAY );
	System.out.println( minuteOfDay );

	Instant instant = sylvester.atZone( ZoneId.systemDefault() ).toInstant();
	Date legacyDate = Date.from( instant );
	System.out.println( legacyDate );

	// ��ͬ��java.text.SimpleDateFormat���µ�DateTimeFormatter���ǲ��ɱ�ģ�Ҳ���̰߳�ȫ��
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "MM dd, yyyy - HH:mm" );
	LocalDateTime parsed = LocalDateTime.parse( "09 03, 2014 - 07:13", formatter );
	String string = formatter.format( parsed );
	System.out.println( parsed );
	System.out.println( string );
    }
}
