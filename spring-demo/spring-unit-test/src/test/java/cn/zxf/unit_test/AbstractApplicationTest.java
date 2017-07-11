package cn.zxf.unit_test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = UnitTestApplication.class )
@Slf4j
public abstract class AbstractApplicationTest {

    protected int port = 8088;

    public void info( String format, Object... arguments ) {
	System.out.println( "\n" );
	log.info( format, arguments );
	System.out.println( "\n" );
    }

}
