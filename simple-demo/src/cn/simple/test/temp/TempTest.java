
package cn.simple.test.temp;

import java.io.IOException;
import java.text.ParseException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TempTest {

    public static void main( String[] args ) throws IOException, InterruptedException, ParseException {
        System.out.println( 1509033600000L );
        System.out.println( System.currentTimeMillis() );
        System.out.println( System.currentTimeMillis() + 24 * 10L * 3600 * 1000L );
        System.out.println( 1509983999999L );
        System.out.println( String.format( "%tF %<tT", 1509033600000L ) );
        System.out.println( String.format( "%tF %<tT", 1509983999999L ) );
    }

}