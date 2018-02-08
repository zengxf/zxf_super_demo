
package cn.simple.test.temp;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) throws Exception {
        int x = 2, y = 3;
        x = x ^ y ^ ( y = x );
        System.out.println( x );
        System.out.println( y );
    }

}