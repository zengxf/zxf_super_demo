package cn.simple.test.jvm.remote.monitor;

import java.util.Map;
import java.util.WeakHashMap;

import cn.simple.util.SleepUtils;

/**
 * 远程 JVM 监控
 * <p>
 * 
 * JVM 参数
 * 
 * <pre>
    -Djava.rmi.server.hostname=127.0.0.1
    -Djava.rmi.server.hostname=192.168.1.161
    -Dcom.sun.management.jmxremote
    -Dcom.sun.management.jmxremote.port=8888
    -Dcom.sun.management.jmxremote.authenticate=false
    -Dcom.sun.management.jmxremote.ssl=false
 * </pre>
 * 
 * 设置密码
 * 
 * <pre>
 * echo "admin 123" > /base-data/jdk1.8.0_91/jre/lib/management/jmxremote.password    
 * 修改文件权限                                                                             
 * chmod 0400 /base-data/jdk1.8.0_91/jre/lib/management/jmxremote.password
 * </pre>
 * 
 * JConsole 连接
 * 
 * <pre>
 * 192.168.1.161:8888
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2018-03-19
 */
public class TestJvmRemoteMonitor {

    public static class HoldMemoryTask implements Runnable {
        static Map<Long, byte[]> map = new WeakHashMap<Long, byte[]>();

        @Override
        public void run() {
            while ( true ) {
                map.put( System.nanoTime(), new byte[512] );
                SleepUtils.millisecond( 1 );
            }
        }
    }

    public static void main( String[] args ) {
        new Thread( new HoldMemoryTask(), "test-001" ).start();
    }

}
