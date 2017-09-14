
package cn.simple.test.temp;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TempTest {

    public static void main( String[] args ) throws IOException, InterruptedException, ParseException {
        LocalDate temp = LocalDate.now().minusDays(7);
        System.out.println( temp );
    }

}