package cn.simple.test.date;

import java.util.Calendar;

public class GetDate {

    public static void main( String[] args ) {
	Calendar calendar = Calendar.getInstance();
	// calendar.set( Calendar.MONTH, 5 );
	calendar.set( Calendar.DAY_OF_MONTH, 7 );
	calendar.set( Calendar.HOUR_OF_DAY, 0 );
	calendar.set( Calendar.MINUTE, 0 );
	calendar.set( Calendar.SECOND, 0 );

	System.out.printf( "%tF %<tT %n", calendar.getTime() );

	calendar.set( Calendar.DAY_OF_MONTH, 27 );
	System.out.printf( "%tF %<tT %n", calendar.getTime() );

    }
}
