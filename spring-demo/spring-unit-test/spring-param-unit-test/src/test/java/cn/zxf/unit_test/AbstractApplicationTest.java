package cn.zxf.unit_test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith( SpringRunner.class )
@SpringBootTest
@Slf4j
public abstract class AbstractApplicationTest {

    @Autowired
    protected WebApplicationContext context;

    public void info( String format, Object... arguments ) {
        System.out.println();
        System.out.println();
        log.info( format, arguments );
        System.out.println();
        System.out.println();
    }

}
