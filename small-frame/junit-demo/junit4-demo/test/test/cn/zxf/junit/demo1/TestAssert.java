package test.cn.zxf.junit.demo1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class TestAssert {

    @Test
    public void test1() {
	assertThat( true, is( true ) );
	assertThat( "a", is( "a" ) );
    }

    @Test
    @Ignore( "don't forget me!" )
    public void somethingWeCannotHandleRightNow() {
	System.out.println( "--------" );
    }
}
