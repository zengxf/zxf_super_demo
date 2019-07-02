package cn.simple.test.illustration.lombok_annotation.proxy;

import lombok.AllArgsConstructor;

@AllArgsConstructor( staticName = "of" )
public class TestImpl implements ITest {

    private String sign;

    @Override
    public void test( String name ) {
        System.out.printf( "test => %s == %s %n", this.sign, name );
    }

    @Override
    public int get( String name ) {
        System.out.printf( "get => %s == %s %n", this.sign, name );
        return 10;
    }

}
