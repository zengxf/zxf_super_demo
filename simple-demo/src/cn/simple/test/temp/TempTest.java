
package cn.simple.test.temp;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) {
//        String s = new String( "1" );
//        s.intern();
//        String s2 = "1";
//        System.out.println( s == s2 );

        String s3 = new String( "1" ) + new String( "1" );
        s3.intern();
        String s4 = "11";
        System.out.println( s3 == s4 );
    }

}
