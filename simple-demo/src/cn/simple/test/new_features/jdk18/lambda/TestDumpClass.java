package cn.simple.test.new_features.jdk18.lambda;

/**
 * 测试产生的中间类 <br>
 * -Djdk.internal.lambda.dumpProxyClasses
 * 
 * @author zengxf
 */
// java -Djdk.internal.lambda.dumpProxyClasses cn.simple.test.new_features.jdk18.lambda.TestDumpClass
// System.setProperty( "jdk.internal.lambda.dumpProxyClasses", "D:/test/dump/java8" );
// -Djdk.internal.lambda.dumpProxyClasses=D:/test/dump/java8
public class TestDumpClass {
    public static void main( String[] args ) {
//	System.setProperty( "jdk.internal.lambda.dumpProxyClasses", "D:/test/dump/java8" );
	a();
    }

    static void a() {
	Runnable run = () -> {
	};
	System.out.println( run );
    }
}
