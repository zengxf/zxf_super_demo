package cn.simple.test.new_features.jdk18.lambda;

public class TestScope {
    int	       count;
    static int num;

    void test() {
	Runnable run = () -> {
	    // lambda �ڲ�����ʵ�����ֶ��Լ���̬�����Ǽ��ɶ��ֿ�д
	    count++;
	    num++;
	};
	run.run();
    }

    void print() {
	System.out.println( String.format( "%d - %d", count, num ) );
    }

    public static void main( String[] args ) {
	TestScope scope = new TestScope();
	scope.test();
	scope.print();
    }

}
