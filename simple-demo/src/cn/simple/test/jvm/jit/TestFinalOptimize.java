package cn.simple.test.jvm.jit;

/**
 * �����뿴������ final ��ʶ�Ƿ���
 * <p>
 * �ֲ������ǲ����� final ��ʶ����˲���������Ż�����
 * 
 * <p>
 * Created by zengxf on 2017-10-16
 */
public class TestFinalOptimize {

    static final String NAME = "zxf";

    final String        name = "feng";

    public static void main( String[] args ) {
        final String address = "lh";
        System.out.println( address );
    }

    void test() {
        final String address = "lh";
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println( address );
            }
        };
        r.run();
    }
}
