package cn.simple.test.new_features.jdk1_8.interface_def;

public class Main {
    static class Test1 extends Print implements IEcho {

    }

    static class D implements IPrint {
	public void print() {
	    System.out.println( "Hello from D" );
	}
    }

    static class C extends D implements IPrint, IEcho {
    }

    public static void main( String[] args ) {
	// �̳й��򣺸��� > �ӿ���(��) > �ӿ���
	new User().say();

	// �ӽӿڸ�����
	new Test1().print();

	//  
	new C().print();
    }

}
