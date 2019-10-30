package cn.simple.test.temp;

// M:\zxf-demo-github\zxf_super_demo\simple-demo\bin\main\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) {

        System.out.println( test5() );
    }

    public static int test5() {
        int b = 20;

        try {
            System.out.println( "try block" );

            b = b / 0;

            return b += 80;
        } catch ( Exception e ) {

            System.out.println( "catch block" );
            return b += 15;
        } finally {

            System.out.println( "finally block" );

            if ( b > 25 ) {
                System.out.println( "b>25, b = " + b );
            }
            // 说明了发生异常后，catch中的return语句先执行，确定了返回值后再去执行finally块，执行完了catch再返回，finally里对b的改变对返回值无影响
            b += 50;
        }

        // return b;
    }

}
