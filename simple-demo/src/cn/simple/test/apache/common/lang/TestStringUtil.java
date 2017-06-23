package cn.simple.test.apache.common.lang;

import java.util.Date;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public class TestStringUtil {

    public static void main( String[] args ) {
	// test();

	String enumName = "RECOMMEND_CV_TO_COUNT";

	enumName = enumName.toLowerCase();
	String[] arr = enumName.split( "_" );
	String name = "";
	for ( String temp : arr ) {
	    name += StringUtils.capitalize( temp );
	}
	System.out.println();
	System.out.println( name );
	// System.out.println( name + "Test" );
    }

    static void test() {
	System.out.println( DateUtils.addDays( new Date(), 3 ) );
	System.out.println( DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT );
	System.out.println( ArrayUtils.isSameLength( new String[] { "dd" }, new String[] { "e" } ) );
	System.out.println( NumberUtils.min( 2, 3, 4, 1 ) );
	System.out.println( NumberUtils.min( 2, 3, 4 ) );
    }

}
