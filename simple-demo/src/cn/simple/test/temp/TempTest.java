
package cn.simple.test.temp;

import lombok.Data;
import lombok.EqualsAndHashCode;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) throws Exception {

    }

    @Data
    public static class A {
        String  name;
        Integer age;
    }

    @Data
    @EqualsAndHashCode( callSuper = true )
    public static class B extends A {
        String  namea;
        Integer agea;
    }

}