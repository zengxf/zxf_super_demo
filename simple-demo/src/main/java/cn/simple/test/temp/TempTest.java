package cn.simple.test.temp;

// M:\project\zxf_super_demo\simple-demo\bin\main\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) {
        System.out.println( ( Long.MAX_VALUE - System.currentTimeMillis() ) / 1000L / 3600L / 24L / 366L );
        System.out.printf( "%tF %<tT %n", ( 1000L * Integer.MAX_VALUE ) );
        System.out.printf( "%tF %<tT %n", ( 1000L * Integer.MIN_VALUE ) );
    }

}