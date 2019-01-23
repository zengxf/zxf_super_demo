package cn.simple.test.jdkapi.reflex.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@TestB
public class TestClass {

    public static void main( String[] args ) {
	Annotation[] arr = TestClass.class.getDeclaredAnnotations();
	System.out.println( Arrays.toString( arr ) );
    }

}
