
package cn.simple.test.temp;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    interface Function {
        Integer apply( String v );
    }

    static class A implements Function {

        @Override
        public Integer apply( String t ) {
            return null;
        }

    }

    public static void main( String[] args ) throws CloneNotSupportedException {
        A a = new A();
        a.apply( "2" );
    }

}