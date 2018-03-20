
package cn.simple.test.temp;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static final int AA = 33;

    public static void main( String[] args ) {
        Integer v = 1021;
        String s = String.format( "%.2f%%", v.doubleValue() / 100 );
        System.out.println( s );
    }

}