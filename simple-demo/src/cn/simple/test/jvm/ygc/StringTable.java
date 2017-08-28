package cn.simple.test.jvm.ygc;

import java.util.UUID;

/**
 * ���� String.intern() ����� YGC Խ��Խ�� <br>
 * JVM ����
 * 
 * <pre>
 * -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -Xmx2G -Xms2G -Xmn100M
 * </pre>
 * 
 * ����
 * 
 * <pre>
 * YGC���̻�ɨ��StringTable����Խ��ʱ��Խ������Full GC����CMS GC���̻��StringTable������
 * ��֤��jmap -histo:live pid
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2017-08-28
 */
public class StringTable {

    public static void main( String[] args ) throws InterruptedException {
        Thread.sleep( 5_000L );
        for ( int i = 0; i < 1000_0000; i++ ) {
            UUID.randomUUID().toString().intern();
        }
    }

}
