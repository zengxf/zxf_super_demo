package cn.simple.test.date;

import java.util.Date;

public class Date2Format {

    public static void main( String[] args ) {
	
	String str = String.format("%tF %<tT -> %tF %<tT", new Date(), new Date());
	System.out.println( str );
	
    }
    
}
