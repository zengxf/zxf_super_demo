package cn.simple.test.temp;

// M:\zxf-demo-github\zxf_super_demo\simple-demo\bin\main\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) {
        double p = 0.001;
        int n = 200;
        long v = (long) ( -n * Math.log( p ) / ( Math.log( 2 ) * Math.log( 2 ) ) );
        System.out.println( v );
    } 

}
