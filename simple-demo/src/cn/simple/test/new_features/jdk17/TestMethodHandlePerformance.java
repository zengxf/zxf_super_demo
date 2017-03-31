package cn.simple.test.new_features.jdk17;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * ���Է�������뷴�������
 * 
 * @author zengxf
 */
public class TestMethodHandlePerformance {
    static int count = 10_0000;

    static class MyClass {
	int i = 0;

	public void test( String msg ) {
	    i++;
	}
    }

    public static void main( String[] args ) throws Throwable {
	testReflect();
	testHandle();

	System.out.println( "-------------------" );

	testReflect();
	testHandle();
    }

    /**
     * ����-�������
     * 
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws Throwable
     */
    static void testHandle() throws NoSuchMethodException, IllegalAccessException, Throwable {
	MethodType mt = MethodType.methodType( void.class, String.class );
	MethodHandle mh = MethodHandles.lookup().findVirtual( MyClass.class, "test", mt );
	MyClass obj = new MyClass();

	long start = System.nanoTime();

	for ( int i = 0; i < count; i++ ) {
	    mh.invoke( obj, "ok" );
	}

	long end = System.nanoTime();
	System.out.println( "handle -> " + ( end - start ) / 1000 + " us" );
    }

    /**
     * ����-����
     * 
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws Throwable
     */
    static void testReflect() throws NoSuchMethodException, IllegalAccessException, Throwable {
	Method m = MyClass.class.getMethod( "test", String.class );
	MyClass obj = new MyClass();

	long start = System.nanoTime();

	for ( int i = 0; i < count; i++ ) {
	    m.invoke( obj, "ok" );
	}

	long end = System.nanoTime();
	System.out.println( "reflect -> " + ( end - start ) / 1000 + " us" );
    }
}
