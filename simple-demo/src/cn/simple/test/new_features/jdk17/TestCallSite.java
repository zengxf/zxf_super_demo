package cn.simple.test.new_features.jdk17;

import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.lang.invoke.VolatileCallSite;

/**
 * 测试回调点
 * 
 * @author zengxf
 */
public class TestCallSite {
    static class MyClass {
	public static void test1( String msg ) {
	    System.out.println( "test static 1 msg => " + msg );
	}

	public static void test2( String msg ) {
	    System.out.println( "test static 2 msg => " + msg );
	}
    }

    public static void main( String[] args ) throws Throwable {
	// testConstant();
	// testMutable();
	testVolatile();
    }

    /**
     * 不可变的调用点
     * 
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws Throwable
     */
    static void testConstant() throws NoSuchMethodException, IllegalAccessException, Throwable {
	MethodType mt = MethodType.methodType( void.class, String.class );
	MethodHandle mh = MethodHandles.lookup().findStatic( MyClass.class, "test1", mt );

	ConstantCallSite cs = new ConstantCallSite( mh );
	MethodHandle mh2 = cs.dynamicInvoker();

	try {
	    cs.setTarget( mh2 );
	} catch ( UnsupportedOperationException e ) {
	    System.out.println( "常量调用点不支持设置 target ！" );
	}

	mh2.invokeExact( "ok 1" );
	mh2.invoke( "ok 2" );
    }

    /**
     * 普通可变调用点
     * 
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws Throwable
     */
    static void testMutable() throws NoSuchMethodException, IllegalAccessException, Throwable {
	MethodType mt = MethodType.methodType( void.class, String.class );
	MethodHandle mh = MethodHandles.lookup().findStatic( MyClass.class, "test1", mt );
	MethodHandle mh2 = MethodHandles.lookup().findStatic( MyClass.class, "test2", mt );

	MutableCallSite cs = new MutableCallSite( mh );

	MethodHandle mhNew = cs.dynamicInvoker();
	mhNew.invokeExact( "ok 1" );
	mhNew.invoke( "ok 2" );

	cs.setTarget( mh2 ); // 非线程安全

	mhNew = cs.dynamicInvoker();
	mhNew.invokeExact( "mut ok 1" );
	mhNew.invoke( "mut ok 2" );
    }

    /**
     * 线程安全调用点
     * 
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws Throwable
     */
    static void testVolatile() throws NoSuchMethodException, IllegalAccessException, Throwable {
	MethodType mt = MethodType.methodType( void.class, String.class );
	MethodHandle mh = MethodHandles.lookup().findStatic( MyClass.class, "test1", mt );
	MethodHandle mh2 = MethodHandles.lookup().findStatic( MyClass.class, "test2", mt );

	VolatileCallSite cs = new VolatileCallSite( mh );

	MethodHandle mhNew = cs.dynamicInvoker();
	mhNew.invokeExact( "ok 1" );
	mhNew.invoke( "ok 2" );

	cs.setTarget( mh2 ); // 线程安全

	mhNew = cs.dynamicInvoker();
	mhNew.invokeExact( "vol ok 1" );
	mhNew.invoke( "vol ok 2" );
    }

}
