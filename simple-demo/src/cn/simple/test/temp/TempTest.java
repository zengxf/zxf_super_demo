
package cn.simple.test.temp;

import java.io.IOException;
import java.text.ParseException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TempTest {

    public static void main( String[] args ) throws IOException, InterruptedException, ParseException {
        log.info( "{}", reverse( 213032 ) );
    }

    static int reverse( int x ) {
        if ( x == 0 )
            return x;
        int ret = 0;
        while ( x != 0 ) {
            ret = ret * 10 + x % 10;
            x = x / 10;
        }
        return ret;
    }
}