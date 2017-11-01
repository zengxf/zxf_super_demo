package cn.simple.test.jvm.jdb;

/**
 * ���̲߳���
 * 
 * <p>
 * Created by zengxf on 2017-10-23
 * 
 * @see TestJdb.Doc
 * @see Doc
 */
public class TestThreads {
    public static void main( String[] args ) {
        Runnable a = () -> {
            log( "test 1 entry ..." );
            sleep( 1000 );
            log( "test 1 end !!!" );
        };
        Runnable b = () -> {
            log( "test 2 entry ..." );
            sleep( 1000 );
            log( "test 2 end !!!" );
        };
        new Thread( a, "test-jdb-a" ).start();
        new Thread( b, "test-jdb-b" ).start();
    }

    static void log( String msg ) {
        System.out.println( "\n\n" + msg + "\n\n" );
    }

    static void sleep( int millis ) {
        try {
            Thread.sleep( millis );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

    /**
     * �� jdb ����
     * <p>
     * 
     * ����
     * 
     * <pre>
     * bin> jdb -sourcepath ../src cn.simple.test.jvm.jdb.TestThreads      # �����ڲ鿴Դ��
     * stop at cn.simple.test.jvm.jdb.TestThreads:15    # �У���Ҫȫ��
     * run          # ��ʼ����
     * next         # ��һ��(F6)
     * step         # ���뷽����(F5)
     * step up      # ����������(F7)
     * cont         # ���е���һ���ϵ�(F8)
     * list         # �鿴Դ��
     * -- �߳��й�
     * threads [threadgroup]     -- �г��߳�
     * thread {thread id}        -- ����Ĭ���߳�
     * suspend [thread id(s)]    -- �����߳� (Ĭ��ֵ: all)
     * resume [thread id(s)]     -- �ָ��߳� (Ĭ��ֵ: all)
     * threadgroups              -- �г��߳���
     * threadgroup {name}        -- ���õ�ǰ�߳���
     * -- ���Խ���
     * 1) ����ͣ���е��߳�
     * 2) �ָ�ĳ��Ҫ���Ե��߳�
     * 3) �����꣬���Ҫ������һ���̣߳����� thread {tId} ��ת
     * </pre>
     * 
     * <p>
     * Created by zengxf on 2017-10-23
     * 
     * @see TestJdb.Doc
     */
    static class Doc {
    }
}
