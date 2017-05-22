package cn.simple.test.socket;

/**
 * �����ṩ�˿ڣ�����Զ��JVM����
 * 
 * <p>
 * Created by zxf on 2017-05-17
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
// Զ�̵���
// JVM ������
// -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000

// jconsole Զ������
// Linux:
// ��������
// echo "admin 123" > /base-data/jdk1.8.0_91/jre/lib/management/jmxremote.password
// �޸��ļ�Ȩ��
// chmod 0400 /base-data/jdk1.8.0_91/jre/lib/management/jmxremote.password
// JVM ������
// -Dcom.sun.management.jmxremote=true
// -Djava.rmi.server.hostname=10.10.10.2
// -Djava.rmi.server.hostname=120.25.93.177
// -Dcom.sun.management.jmxremote
// -Dcom.sun.management.jmxremote.port=9000
// -Dcom.sun.management.jmxremote.authenticate=true
// -Dcom.sun.management.jmxremote.ssl=true

// ��������
// mkdir -p cn/simple/test/socket
// ���� Java
// java JVM_PARAM cn.simple.test.socket.TestRemoteDebug
// java -Djava.rmi.server.hostname=120.25.93.177 -Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.port=9000 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false
// cn.simple.test.socket.TestRemoteDebug

// JConsole ���� URL
// service:jmx:rmi:///jndi/rmi://120.25.93.177:9000/jmxrmi
// service:jmx:rmi://120.25.93.177:9000/jndi/rmi://120.25.93.177:9000/jmxrmi
//