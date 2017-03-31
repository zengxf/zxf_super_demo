package cn.simple.test.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TraversalDate {
    public static final long MILLIS_PER_DAY = 86400000L;

    public static void main( String[] args ) {
	Date start = parseDate( "yyyy-MM-dd", "2016-06-28", "2015-09-01" );
	Date end = parseDate( "yyyy-MM-dd", "2016-06-21", "2026-09-01" );
	end.setTime( end.getTime() + MILLIS_PER_DAY );

	if ( start.after( end ) ) {
	    Date temp = end;
	    end = start;
	    start = temp;
	}

	Calendar now = Calendar.getInstance();
	now.set( Calendar.HOUR_OF_DAY, 0 );
	now.set( Calendar.MINUTE, 0 );
	now.set( Calendar.SECOND, 0 );
	now.set( Calendar.MILLISECOND, 0 );

	end = now.getTime().after( end ) ? end : now.getTime();
	now.add( Calendar.DAY_OF_MONTH, -1 );
	start = now.getTime().after( start ) ? start : now.getTime();

	System.out.printf( "%tF %n", start );
	System.out.printf( "%tF %n", end );
	System.out.println();

	now.setTime( start );
	while ( now.getTime().getTime() <= end.getTime() ) {
	    System.out.printf( "%tF %n", now.getTime() );
	    now.add( Calendar.DAY_OF_MONTH, 1 );
	}

    }

    public static Date parseDate( String format, String date, String defaultDate ) {
	DateFormat dateFormat = new SimpleDateFormat( format );
	try {
	    return dateFormat.parse( date );
	} catch ( ParseException e ) {
	    try {
		return dateFormat.parse( defaultDate );
	    } catch ( ParseException e1 ) {
		throw new RuntimeException( "defaultDate parse error", e1 );
	    }
	}
    }

}
