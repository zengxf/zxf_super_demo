package cn.simple.test.new_features.jdk1_8.lambda;

import java.util.function.Function;

/**
 * 测试产生的中间类 <br>
 * -Djdk.internal.lambda.dumpProxyClasses<br>
 * 
 * 测试-查看私有方法：javap -p TestDumpClass.class
 * 
 * @author zengxf
 */
// java -Djdk.internal.lambda.dumpProxyClasses cn.simple.test.new_features.jdk18.lambda.TestDumpClass
// System.setProperty( "jdk.internal.lambda.dumpProxyClasses", "D:/test/dump/java8" );
// -Djdk.internal.lambda.dumpProxyClasses=D:/test/dump/java8
public class TestDumpClass {
    public static void main( String[] args ) {
	System.setProperty( "jdk.internal.lambda.dumpProxyClasses", "D:/test/dump/java8" );
	a();
	b();
    }

    static void b() {
	String header = "This is a ";
	Function<Object, String> f = obj -> header + obj.toString();
	String v = f.apply( 23 );
	System.out.println( v );
    }

    static void a() {
	Runnable run = () -> {
	};
	System.out.println( run );
    }
}
