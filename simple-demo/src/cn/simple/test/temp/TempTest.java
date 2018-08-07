
package cn.simple.test.temp;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) {
        System.out.println( Thread.currentThread().getContextClassLoader() );;
        System.out.println( ClassLoader.getSystemClassLoader() );
    }

}
