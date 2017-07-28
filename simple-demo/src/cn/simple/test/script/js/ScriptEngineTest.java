package cn.simple.test.script.js;

import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptEngineTest {

    @SuppressWarnings( "unchecked" )
    public static void main( String[] args ) throws Exception {
	ScriptEngineManager sem = new ScriptEngineManager();
	ScriptEngine engine = sem.getEngineByName( "javascript" ); // python or jython,

	// ���������д������
	engine.put( "msg", "just a test" );
	// ������user
	String str = "msg += '!!!';var user = {name:'tom',age:23,hobbies:['football','basketball']}; ";
	engine.eval( str );

	// ��������������ȡֵ
	String msg = (String) engine.get( "msg" );
	String name = (String) engine.get( "name" );
	String[] hb = (String[]) engine.get( "hobbies" );
	System.out.println( msg );
	System.out.println( name + ":" + hb[0] );

	// ������ѧ����
	engine.eval( "function add (a, b) {c = a + b; return c; }" );

	// ȡ�õ��ýӿ�
	Invocable jsInvoke = (Invocable) engine;

	// ����ӷ�����

	Object result1 = jsInvoke.invokeFunction( "add", new Object[] { 10, 5 } );

	System.out.println( result1 );

	// ���üӷ�����,ע��������ݵķ���

//	Adder adder = jsInvoke.getInterface( Adder.class );
//
//	int result2 = adder.add( 10, 35 );

//	System.out.println( result2 );

	// ����run()����

	engine.eval( "function run() {print('www.java2s.com');}" );

	Invocable invokeEngine = (Invocable) engine;

	Runnable runner = invokeEngine.getInterface( Runnable.class );
	// �����߳�����֮

	Thread t = new Thread( runner );

	t.start();

	t.join();

	// ��������java��

	String jsCode = "importPackage(java.util);  var list2 = Arrays.asList(['A', 'B', 'C']); ";

	engine.eval( jsCode );

	List<String> list2 = (List<String>) engine.get( "list2" );

	for ( String val : list2 ) {
	    System.out.println( val );
	}

    }
}
