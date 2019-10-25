package cn.simple.test.temp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import lombok.RequiredArgsConstructor;

// M:\zxf-demo-github\zxf_super_demo\simple-demo\bin\main\cn\simple\test\temp
@RequiredArgsConstructor( onConstructor = @__( { @BB } ) )
public class TempTest {

    private final String name;
    private String       sign;

}

@Retention( RetentionPolicy.RUNTIME )
@Target( { ElementType.CONSTRUCTOR } ) @interface BB { }