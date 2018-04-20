
package cn.simple.test.temp;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) throws CloneNotSupportedException {
        String info = "中文abcd12345";
        System.out.println( info.substring( 0, 8 ) );
        System.out.println( String.format( "%tF %<tT", System.currentTimeMillis() ) );
    }

}