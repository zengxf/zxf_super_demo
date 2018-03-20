package cn.simple.test.jvm.remote.debug;

/**
 * 远程调试
 * <p>
 * 
 * JVM 参数：
 * 
 * <pre>
 *  -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000      // >= jdk1.5
 *  -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8000             // jdk1.4
 *  -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8002   // 等到eclipse连接，服务才能用
 *  测试：
 *      java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 cn.simple.test.jvm.remote.debug.TestRemoteDebug
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2018-03-19
 */
public class TestRemoteDebug {

    public static void main( String[] args ) throws InterruptedException {
        System.out.println( System.getProperty( "java.version" ) );
        int i = 0;
        while ( true ) {
            System.out.printf( "i: %s %n", i++ );
            System.out.printf( "date: %tT %n", System.currentTimeMillis() );
            Thread.sleep( 1000L );
        }
    }

}
