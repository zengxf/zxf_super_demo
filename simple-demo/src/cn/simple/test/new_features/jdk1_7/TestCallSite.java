package cn.simple.test.new_features.jdk1_7;

import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.lang.invoke.VolatileCallSite;
import java.lang.invoke.WrongMethodTypeException;

/**
 * ���Իص���
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

	public static void testNum( Number num ) {
	    System.out.println( "test static num => " + num );
	}
    }

    public static void main( String[] args ) throws Throwable {
	// testVolatile();
	// testMutable();
	// testConstant();
	testInvoke();
    }

    /**
     * ���� invoke �� invokeExact
     * 
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws Throwable
     */
    static void testInvoke() throws NoSuchMethodException, IllegalAccessException, Throwable {
	Integer num = 33;

	MethodType mt = MethodType.methodType( void.class, Number.class );
	MethodHandle mh = MethodHandles.lookup().findStatic( MyClass.class, "testNum", mt );
	try {
	    mh.invokeExact( num ); // ����Ҫ��ȫƥ��
	} catch ( WrongMethodTypeException e ) {
	    System.err.println( "����û����ȫƥ�䣡-> e: " + e.getMessage() );
	}
	mh.invoke( num ); // ���Ͳ���Ҫ��ȫƥ�䣬������������
    }

    /**
     * ���ɱ�ĵ��õ�
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
	    cs.setTarget( mh2 ); // ��������
	} catch ( UnsupportedOperationException e ) {
	    System.err.println( "�������õ㲻֧������ target ��" );
	}

	mh2.invokeExact( "ok 1" );
	mh2.invoke( "ok 2" );
    }

    /**
     * ��ͨ�ɱ���õ�
     * 
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws Throwable
     */
    static void testMutable() throws NoSuchMethodException, IllegalAccessException, Throwable {
	MethodType mt = MethodType.methodType( void.class, String.class );
	MethodHandle mh = MethodHandles.lookup().findStatic( MyClass.class, "test1", mt );
	MethodHandle mh2 = MethodHandles.lookup().findStatic( MyClass.class, "test2", mt );

	MutableCallSite cs = new MutableCallSite( mh ); // ��ͨ�ɱ���õ�

	MethodHandle mhNew = cs.dynamicInvoker();
	mhNew.invokeExact( "ok 1" );
	mhNew.invoke( "ok 2" );

	cs.setTarget( mh2 ); // ���̰߳�ȫ

	mhNew = cs.dynamicInvoker();
	mhNew.invokeExact( "mut ok 1" );
	mhNew.invoke( "mut ok 2" );
    }

    /**
     * �̰߳�ȫ���õ�
     * 
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws Throwable
     */
    static void testVolatile() throws NoSuchMethodException, IllegalAccessException, Throwable {
	MethodType mt = MethodType.methodType( void.class, String.class );
	MethodHandle mh = MethodHandles.lookup().findStatic( MyClass.class, "test1", mt );
	MethodHandle mh2 = MethodHandles.lookup().findStatic( MyClass.class, "test2", mt );

	VolatileCallSite cs = new VolatileCallSite( mh ); // �̰߳�ȫ���õ�

	MethodHandle mhNew = cs.dynamicInvoker();
	mhNew.invokeExact( "ok 1" );
	mhNew.invoke( "ok 2" );

	cs.setTarget( mh2 ); // �̰߳�ȫ

	mhNew = cs.dynamicInvoker();
	mhNew.invokeExact( "vol ok 1" );
	mhNew.invoke( "vol ok 2" );
    }

}
