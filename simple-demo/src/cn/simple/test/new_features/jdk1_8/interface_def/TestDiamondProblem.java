package cn.simple.test.new_features.jdk1_8.interface_def;

public class TestDiamondProblem {

    static interface A {
	default void test() {
	    System.out.println( "Hello from A" );
	}
    }

    static interface B extends A {
    }

    static interface C extends A {
	// void hello(); // ���ϳ��󷽷�ʱ��C �����壬��� D ��ʵ�� C �ķ���
    }

    static class D implements B, C {
    };

    public static void main( String[] args ) {
	new D().test();
    }

}
