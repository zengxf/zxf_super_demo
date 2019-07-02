package cn.simple.test.illustration.lombok_annotation.proxy;

public class Main {

    public static void main( String[] args ) {
        ITest test = TestProxy.of();
        test.test( "bb" );
        int value = test.get( "aa" );
        System.out.println( "get-value => " + value );
    }

}
