
package cn.simple.test.temp;

public class TempTest {

    public static void main( String[] args ) throws Exception {
        System.out.println( ( ( 1L << 45 ) - System.currentTimeMillis() ) / 1000 / 3600 / 24 / 30 / 12 );
    }

}