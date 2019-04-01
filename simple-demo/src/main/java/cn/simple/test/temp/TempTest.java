package cn.simple.test.temp;

import java.util.Date;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) {
        String str = String.format( "%tF %<tH:%<tM", new Date() );
        System.out.println( "|" + str + "|" );
    }

}