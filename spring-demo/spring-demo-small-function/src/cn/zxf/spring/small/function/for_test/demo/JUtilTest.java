package cn.zxf.spring.small.function.for_test.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles( "dev" )
@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = TestConfig.class )
public class JUtilTest {

    @Autowired
    private TestBean test;

    @Test
    public void test() {
	String value = "from development profile";
	String actual = test.getContent();
	Assert.assertEquals( value, actual );
    }

}
