package cn.simple.test.jvm.off_heap;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import sun.nio.ch.DirectBuffer;

/**
 * System.gc���ǿ��Խ�����ʹ�� -XX:+DisableExplicitGC ��<br>
 * ��ʵһ����cms gc������ͨ�� -XX:+ExplicitGCInvokesConcurrent Ҳ��������΢��Чһ���gc��Ҳ���ǲ���gc��
 * 
 * <p>
 * Created by zengxf on 2017-09-08
 */
public class TestDirectBuffer2 {

    public static void main( String[] args ) throws InterruptedException {
        test4();
    }

    static void test() {
        // ����128MBֱ���ڴ�
        ByteBuffer.allocateDirect( 1024 * 1024 * 128 );
        try {
            TimeUnit.SECONDS.sleep( 10 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println( "ok" );
    }

    /**
     * ��������1������JVM���� -Xmx100m �������쳣����Ϊ���û����-XX:MaxDirectMemorySize��<br>
     * ��Ĭ����-Xmx����ֵ��ͬ������128Mֱ���ڴ泬�����Ʒ�Χ��
     */
    static void test1() {
        test();
    }

    /**
     * ��������2������JVM���� -Xmx256m ��������������Ϊ128MС��256M�����ڷ�Χ�ڷ��䡣
     */
    static void test2() {
        test();
    }

    /**
     * ��������3������JVM���� -Xmx256m -XX:MaxDirectMemorySize=100M �������쳣�������ֱ���ڴ�128M�����޶���100M��
     */
    static void test3() {
        test();
    }

    /**
     * ��������4������JVM���� -Xmx768m �����г���۲��ڴ�ʹ�ñ仯��<br>
     * �ᷢ��clean()���ڴ������½���˵��ʹ��clean()��������Ч��ʱ����ֱ�ӻ��档
     * 
     * @throws InterruptedException
     */
    static void test4() throws InterruptedException {
        TimeUnit.SECONDS.sleep( 10 );
        System.out.println( "alloc start ..." );
        // ����512MBֱ�ӻ���
        ByteBuffer bb = ByteBuffer.allocateDirect( 1024 * 1024 * 512 );
        System.out.println( "alloc end" );

        TimeUnit.SECONDS.sleep( 10 );
        System.out.println( "clear start ..." );
        // ���ֱ�ӻ���
        ( (DirectBuffer) bb ).cleaner().clean();
        // bb.clear(); // ���յ��� Buffer �࣬�������
        System.out.println( "clear end" );

        TimeUnit.SECONDS.sleep( 10 );
        System.out.println( "ok" );
    }

}
