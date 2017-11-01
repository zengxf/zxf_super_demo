package cn.simple.test.jvm.jdb;

import java.lang.management.ManagementFactory;

/**
 * Created by zengxf on 2017-10-20
 * 
 * @see Doc
 */
public class TestJdb {

    public static void main( String[] args ) {
        System.out.println( ManagementFactory.getRuntimeMXBean().getName() );

        int i = 5;
        int j = 6;
        int sum = add( i, j );
        System.out.println( "add sum: " + sum );

        A a = new A();
        System.out.println( a );

        sum = 0;
        for ( i = 0; i < 100; i++ )
            sum += i;

        System.out.println( "�ܺ�: " + sum );
    }

    public static int add( int augend, int addend ) {
        int sum = augend + addend;
        return sum;
    }

    static class A {
        B b = new B();
    }

    static class B {
        String a = "test ��";
    }

    /**
     * �� jdb ����
     * <p>
     * 
     * ����
     * 
     * <pre>
     * simple-demo> javac -g -d bin src\cn\simple\test\jvm\jdb\TestJdb.java
     * > cd bin
     * > jdb cn.simple.test.jvm.jdb.TestJdb
     * > jdb -sourcepath ../src cn.simple.test.jvm.jdb.TestJdb      # �����ڲ鿴Դ��
     * help         # �鿴������Ϣ
     * stop at cn.simple.test.jvm.jdb.TestJdb:15        # �У���Ҫȫ��
     * stop in cn.simple.test.jvm.jdb.TestJdb.main      # ����
     * run          # ��ʼ����
     * next         # ��һ��(F6)
     * step         # ���뷽����(F5)
     * step up      # ����������(F7)
     * cont         # ���е���һ���ϵ�(F8)
     * stepi        # ��һ��ָ��
     * print i      # ��ӡ������ֵ
     * locals       # �鿴���оֲ�����
     * dump i       # ���������Ϣ����չ�����������ֶε�ֵ��ֻ��ʾ��ǰ��
     * list         # �鿴Դ��
     * clear class:line   # ������еĶϵ�
     * clear        # �г��ϵ㣬stop Ҳ��
     * </pre>
     * 
     * <p>
     * Created by zengxf on 2017-10-20
     */
    static class Doc {
    }
}
