
package cn.simple.test.temp;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) throws CloneNotSupportedException {
       System.out.println( String.class.getClassLoader() );
       System.out.println( TempTest.class.getClassLoader() );
       System.out.println( TempTest.class.getClassLoader().getParent() );
       System.out.println( TempTest.class.getClassLoader().getParent().getParent() );
       System.out.printf( "%tF %<tT", 1528872068639L );
    }

}