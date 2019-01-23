package cn.simple.test.temp;

import java.time.LocalDate;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) {
        LocalDate ld = LocalDate.now()
                .minusYears( 1 )
                .withMonth( 1 ) // 存在跨年，与前端不一致
                .withDayOfMonth( 1 );
        System.out.println( ld.getDayOfWeek()
                .getValue() );

        int days = LocalDate.of( 2019, 1, 1 )
                .getDayOfYear();
        int week = ( ( days + 1 - 1 ) / 7 ) + 1;
        System.out.println( week );
    }

}