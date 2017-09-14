package cn.simple.test.jvm.off_heap;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import sun.nio.ch.DirectBuffer;

/**
 * ���� JVM ����
 * 
 * <pre>
 * 1) -verbose:gc -XX:+PrintGCDetails -XX:MaxDirectMemorySize=40M
 * 2) -verbose:gc -XX:+PrintGCDetails -XX:MaxDirectMemorySize=40M -XX:+DisableExplicitGC
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2017-09-08
 */
public class TestDirectBuffer {
    static int k = 1024;

    public static void main( String[] args ) {
        test_base();
        // test_ref();
    }

    /**
     * JVM ������<br>
     * -verbose:gc -XX:+PrintGCDetails -XX:MaxDirectMemorySize=40M <br>
     * -verbose:gc -XX:+PrintGCDetails -XX:MaxDirectMemorySize=40M -XX:+DisableExplicitGC <br>
     */
    static void test_base() {
        int i = 0;
        while ( true ) {
            DirectBuffer bf = (DirectBuffer) ByteBuffer.allocateDirect( 10 * k * k );
            bf.cleaner().clean(); // ������
            // System.gc();
            System.out.println( "loop " + ++i );
        }
    }

    /**
     * �������õ�Ӱ�� <br>
     * JVM ������<br>
     * -verbose:gc -XX:+PrintGCDetails -XX:MaxDirectMemorySize=40M <br>
     * System.gc() �� Bits.reserveMemory() ���� <br>
     */
    static void test_ref() {
        int i = 0;
        List<ByteBuffer> list = new ArrayList<>();
        while ( true ) {
            ByteBuffer bf = ByteBuffer.allocateDirect( 10 * k * k ); // �����õĻ����򲻻���
            list.add( bf );
            System.out.println( "loop " + ++i );
        }
    }
}
