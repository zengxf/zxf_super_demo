
package cn.simple.test.temp;

import lombok.Data;
import lombok.EqualsAndHashCode;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) throws Exception {
        B a = new B();
        B b = new B();
        System.out.println( a.hashCode() );
        System.out.println( b.hashCode() );
        System.out.println( a.equals( b ) );
    }

    // @Data
    public static class A {
        String  name;
        Integer age;
    }

    @Data
    @EqualsAndHashCode( callSuper = false )
    public static class B extends A {
        String  namea;
        Integer agea;
    }

}