package test.temp;

import java.time.LocalDate;

// M:\zxf-demo-github\zxf_super_demo\simple-demo\bin\main\test\temp
public class TempTest {

    public static void main( String[] args ) throws Exception {
        System.out.println( LocalDate.now()
                .minusDays( 45 ) );
    }
}
